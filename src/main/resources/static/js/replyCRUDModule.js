
var replyManager = (function() {
	
	function printReplies(self,result,job,job2) {
					var context = "";
					for (var i = 0; i < result.replies.length; i++) {
						var reply = result.replies[i];
						var likeCnt = 0;
						var disLikeCnt = 0;
						var likeOnOff = "off";
						var disLikeOnOff = "off";
						var userPhoto = reply.user.photo;
						var thumbUpImgUrl = "images/icon/thumbsUp.png";
						var thumbDownImgUrl = "images/icon/thumbsDown.png";
						var loginComplete = "";
						for (const key in result.likedReplyList) {
							if (result.likedReplyList[key] == reply.id) {
								thumbUpImgUrl = "images/icon/thumbsUpFilled.png";
								likeOnOff = "on";
							}
						}
						for (const key in result.disLikedReplyList) {
							if (result.disLikedReplyList[key] == reply.id) {
								thumbDownImgUrl = "images/icon/thumbsDownFilled.png";
								disLikeOnOff = "on";
							}
						}
						if (result.likeCount[reply.id] == undefined) {
							likeCnt = 0;
						} else {
							likeCnt = result.likeCount[reply.id];
						}
						if (result.disLikeCount[reply.id] == undefined) {
							disLikeCnt = 0;
						} else {
							disLikeCnt = result.disLikeCount[reply.id];
						}
						if (reply.user.photo == null) {
							userPhoto = "defaultProfile.png";
						}
						if (reply.user.id == result.userId) {
							loginComplete = "<div id='replyUpdateDelete'><button id='reply_update' value='off' name='boxing'>수정</button><button id='reply_delete' value='off' name='boxing'>삭제</button></div>";
						}
						context
							+= "<div id='" + reply.id + "'>"
							+ "<div class='reply_header'>"
							+ "<a href='/userInfo?userid=" + reply.user.id + "'>"
							+ "<img src='/images/userProfile/" + userPhoto + "'>"
							+ "</a>"
							+ "<a href='/userInfo?userid=" + reply.user.id + "'>"
							+ "<span class='reply_user_id'>" + reply.user.id + "</span>"
							+ "</a>"
							+ "<span class='reply_update_date'>"
							+ new Date(reply.updateDate).getFullYear() + ". "
							+ (new Date(reply.updateDate).getMonth() + 1) + ". "
							+ new Date(reply.updateDate).getDate()
							+ "</span>"
							+ loginComplete
							+ "</div>"
							+ "<div class='reply_body'><pre>" + reply.content + "</pre></div>"
							+ "<div class='reply_footer'>"
							+ "<button class='like' value='" + likeOnOff + "'>"
							+ "<img src='" + thumbUpImgUrl + "' width=12px; height=12px>"
							+ "</button>"
							+ "<div class='likeCount'>" + likeCnt + "</div>"
							+ "<button class='disLike' value='" + disLikeOnOff + "'>"
							+ "<img src='" + thumbDownImgUrl + "' width=12px; height=12px>"
							+ "</button>"
							+ "<div class='disLikeCount'>" + disLikeCnt + "</div>"
							+ "<button class='reply_reply' value='off' name='boxing'>답글</button><br>"
							+ "<div class='reply_replyClickResult'></div>"
							+ "</div>"
							+ "</div>"
					}
					
					if(job=="all"){
						self.parent().children('.replyContent').html(context);
					}else if(job=="modify"){
						self.parent().parent().parent().parent().parent().html(context);
					}else if(job=="add"){
						if(job2=="reply_create"){
							self.parent().parent().parent().children(".replyZone").children(".replyContent").html(context);
							self.parent().parent().parent().children(".replyZone").children(".replyList").attr("name","unboxing");
							if(self.parent().parent().parent().children(".replyZone").children(".replyList").attr("value")=="off"){
								self.parent().parent().parent().children(".replyZone").children(".replyList").attr("value","on");
							}
							self.parent().parent().parent().children(".reply").attr("name", "boxing");
							self.parent().parent().parent().children(".reply").attr("value", "off");
							self.parent().parent().html("");
						}else if(job2=="reply_reply_create"){
							self = self.parent().parent().parent().parent();
							self.parent().parent().parent().children(".replyZone").children(".replyContent").html(context);
							self.parent().parent().parent().children(".replyZone").children(".replyList").attr("name","unboxing");
							if(self.parent().parent().parent().children(".replyZone").children(".replyList").attr("value")=="off"){
								self.parent().parent().parent().children(".replyZone").children(".replyList").attr("value","on");
							}
							self.parent().parent().parent().children(".reply").attr("name", "boxing");
							self.parent().parent().parent().children(".reply").attr("value", "off");
							self.parent().parent().html("");
						}
					}
				}
	
	/* 가져온 댓글 목록 화면에 */

	/* 댓글 목록 가져오기 */
	var getAll = function(self, albumId, userId) {
		if (self.attr("name") ==  'boxing') {
			self.attr("name", "unboxing");
			$.ajax("/reply/" + albumId + "/" + userId).done(
				function(result){
					printReplies(self,result,"all");
				}	
			);
		}
		if (self.val() == "off")  {
			self.attr("value", "on");
			self.parent().children('.replyContent').css("display", "block");
		} else {
			self.attr("value", "off");
			self.parent().children('.replyContent').css("display", "none");
		}
	};

	var create = function(self, albumId, userId, job) {
		var reviewReply = {
			"review": {
				"multiId": {
					"user": {
						"id": userId
					},
					"album": {
						"id": albumId
					}
				}
			},
			"content": job=='reply_create'? self.parent().parent().children("div").eq(0).children("div").eq(1).children("#textarea").val():self.parent().parent().children("div").eq(0).children("div").eq(1).html()
		};
		$.ajax({
			type: "post",
			url: "/reply/" + userId + "/" + albumId,
			data: JSON.stringify(reviewReply),
			dataType: 'json',
			contentType: "application/json"
		}).done(
			function(result){
				printReplies(self,result,"add",job);
			}
		);
	};

	var loadUpdateForm = function(self) {
		$.ajax({
			url: "replyForm",
			type: "GET"
		}).done(function(form){
			if(self.attr("name")=="boxing"){
				self.attr("name","unboxing");
				var content = self.parent().parent().parent().children(".reply_body").children("pre").text();
				self.parent().parent().parent().children(".reply_body")
				.append("<div id='replyForm' style='padding:0 !important'><textarea id='textarea' wrap=virtual style='width:100%; height:36px;'>" + content + "</textarea>"
				+ '<div style="text-align:right; padding: 5px 0 0 0 !important; margin-right:0 !important">' 
					+ '<span class="NOC" style="float:left"></span>'
					+ '<button id="reply_cancelBtn" style="padding:6px 15px 6px 15px; font-size:11px; color:#606060">취소</button>'
					+ '<button id="reply_updateBtn" style="padding:6px 15px 6px 15px; font-size:11px; color:#606060; background-color:#0000000D; color:#909090; border-radius:4px" disabled>수정</button>'
				+ '</div><br></div>');
			}
			if(self.attr("value")=="off"){
				self.attr("value","on");
				var content = self.parent().parent().parent().children(".reply_body").children("pre").text();
				self.parent().parent().parent().children(".reply_body").children("pre").css("display","none");
				self.parent().parent().parent().children(".reply_footer").css("display","none");
				self.parent().parent().parent().children(".reply_body").children("#replyForm").css("display","block");
				self.parent().parent().parent().children(".reply_body").children("#replyForm").children("#textarea").keyup(function(e){
					var context = $(this).val();
					self.parent().parent().parent().children(".reply_body").children("#replyForm").children("div").children(".NOC").html("최대글자수:1500/" + context.length);
					if(context.length > 1500){
						self.parent().parent().parent().children(".reply_body").children("#replyForm").children("div").children(".NOC").html("최대글자수:1500/1500");
						$(this).val(context.substring(0,1500));
					}
					if(context.length >= 1 & context != content){
						self.parent().parent().parent().children(".reply_body").children("#replyForm").children("div").children("#reply_updateBtn").attr("disabled",false);
						self.parent().parent().parent().children(".reply_body").children("#replyForm").children("div").children("#reply_updateBtn").css({"color":"white","background-color":"slateblue"});
					}else{
						self.parent().parent().parent().children(".reply_body").children("#replyForm").children("div").children("#reply_updateBtn").attr("disabled",true);
						self.parent().parent().parent().children(".reply_body").children("#replyForm").children("div").children("#reply_updateBtn").css({"color":"#909090","background-color":"#0000000D"});
					}
				});
			}else{
				self.attr("value","off");
				self.parent().parent().parent().children(".reply_body").children("pre").css("display","block");
				self.parent().parent().parent().children(".reply_footer").css("display","block");
				self.parent().parent().parent().children(".reply_body").children("#replyForm").css("display","none");
			}
		});
	};
	
	var update = function(self, albumId, userId, replyId, content){
		$.ajax({
			type:"put",
			url:"/reply/" + replyId + "/" + userId + "/" + albumId,
			data: {"content":content}
		}).done(
			function(result){
				printReplies(self,result,"modify");
			}
		);
		alert("댓글이 수정 되었습니다.");
		self.parent().parent().css("display","none");
		self.parent().parent().parent().children("pre").css("display","block");
		self.parent().parent().parent().parent().children(".reply_footer").css("display","block");
		self.parent().parent().parent().parent().children(".reply_header").children("#replyUpdateDelete").children("#reply_update").attr("value","off");
	};
	
	var cancel = function(self){
		self.parent().parent().css("display","none");
		self.parent().parent().parent().children("pre").css("display","block");
		self.parent().parent().parent().parent().children(".reply_footer").css("display","block");
		self.parent().parent().parent().parent().children(".reply_header").children("#replyUpdateDelete").children("#reply_update").attr("value","off");
	};

	var remove = function(self, albumId, userId, replyId) {
		if(confirm("정말로 삭제 하시겠습니까?")){
			$.ajax({
			type: "delete",
			url: "/reply/" + replyId + "/" + userId + "/" + albumId,
			}).done({
			
			});
			self.parent().parent().parent().remove();
		}
		
	};


	var clickThumb = function(self, replyId, job) {
		$.ajax({
			type: "post",
			url: 'reply/thumb/' + replyId + '/' + job,
			success: function(data) {
				if (data.job == "like") {
					if (self.attr("value") == "off") {
						self.attr("value", "on");
						self.children('img').attr("src", "images/icon/thumbsUpFilled.png");
						self.parent().children('.disLike').children('img').attr("src", "images/icon/thumbsDown.png");
						self.parent().children('.disLike').attr("value", "off");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					} else {
						self.attr("value", "off");
						self.children('img').attr("src", "images/icon/thumbsUp.png");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					}
				} else {
					if (self.attr("value") == "off") {
						self.attr("value", "on");
						self.children('img').attr("src", "images/icon/thumbsDownFilled.png");
						self.parent().children('.like').children('img').attr("src", "images/icon/thumbsUp.png");
						self.parent().children('.like').attr("value", "off");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					} else {
						self.attr("value", "off");
						self.children('img').attr("src", "images/icon/thumbsDown.png");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					}
				}
			}
		});
	};

	return {
		getAll: getAll,
		clickThumb: clickThumb,
		create: create,
		loadUpdateForm: loadUpdateForm,
		update: update,
		cancel: cancel,
		remove: remove
	}

})();