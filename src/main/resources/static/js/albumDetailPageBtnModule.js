/**
 * 
 */
var btnManager = (function(){
	
	function check(albumId){
		var result;
		$.ajax({
			url: "/checkReview",
			type:"GET",
			async:false,
			data:{
				"albumId":albumId
			}
		}).done(function(data){
			result = data;
		});
		return result;
	};
	
	var clickMakeMyList = function(self){
		if(self.parent().children("#myListTitle").val() <= 0){
			alert("리스트 이름은 필수 입력 사항 입니다.");
		}else{
			$.ajax({
				url:"/makeMyList",
				type:"post",
				data:{
					"myListTitle":self.parent().children("#myListTitle").val()
				}
			}).done(function(){
				/*self.parent().parent().children("div").eq(1).children("ul").append("<li>차</li>");*/
				console.log("통신성공");
			});
		}
	}
	
	var clickAdd = function(albumId){
		if(check(albumId)==true){
			alert("이미 작성한 리뷰가 있습니다!! 하나의 앨범에 하나의 리뷰만 작성할 수 있습니다.");
		}else{
			if($("#addReviewBtn").val()=="off"){
				$("#addReviewBtn").attr("value","on");
				$("#updateReviewBtn").attr("value","off");
				$("#deleteReviewBtn").attr("value","off");
				$.ajax({
					url: "/writeReviewForm",
					type: "GET",
					data:{
						"albumId":albumId,
						"job":"create"
					}
				}).done(function(form){
					$("#btnClickResult").html(form);
				});
			}else{
				$("#addReviewBtn").attr("value","off");
				$("#btnClickResult").html("");
			}
		}		
	};
	
	var clickUpdate = function(albumId){
		if(check(albumId)==true){
			if($("#updateReviewBtn").val()=="off"){
				$("#updateReviewBtn").attr("value","on");
				$("#addReviewBtn").attr("value","off");
				$("#deleteReviewBtn").attr("value","off");
				$.ajax({
					url: "/writeReviewForm",
					type: "GET",
					data:{
						"albumId":albumId,
						"job":"update"
					}
				}).done(function(form){
					$("#btnClickResult").html(form);
				});
			}else{
				$("#updateReviewBtn").attr("value","off");
				$("#btnClickResult").html("");
			}
		}else{
			alert("작성한 리뷰가 없습니다. 리뷰 수정은 작성한 리뷰가 있어야만 수행 가능 합니다.");
		}
	};
	
	var clickDelete = function(albumId){
		if(check(albumId)==true){
			if($("#deleteReviewBtn").val()=="off"){
				$("#deleteReviewBtn").attr("value","on");
				$("#addReviewBtn").attr("value","off");
				$("#updateReviewBtn").attr("value","off");
				$.ajax({
					url: "/writeReviewForm",
					type: "GET",
					data:{
						"albumId":albumId,
						"job":"delete"
					}
				}).done(function(form){
					$("#btnClickResult").html(form);
				});
			}else{
				$("#deleteReviewBtn").attr("value","off");
				$("#btnClickResult").html("");
			}
		}else{
			alert("작성한 리뷰가 없습니다. 리뷰 삭제는 작성한 리뷰가 있어야만 수행 가능 합니다.");
		}
	};
	
	var clickReply = function(self){
		if(self.attr("name")=="boxing"){
			self.attr("name","unboxing");
			$.ajax({
				url: "/replyForm",
				type: "GET",
			}).done(function(form){
				self.parent().children(".replyClickResult").html(form);
				self.attr("value","on");
				self.parent().children(".replyClickResult").children("div").eq(0).children("div").eq(1).children("#textarea").keyup(function(e){
					var content = $(this).val();
					self.parent().children(".replyClickResult").children("div").eq(1).children(".NOC").html('최대글자수: 1500/' + content.length);
					if(content.length > 1500){
						self.parent().children(".replyClickResult").children("div").eq(1).children(".NOC").html('최대글자수: 1500/1500');
						$(this).val(content.substring(0,1500));
					}
					if(content.replace(/(\s*)/g,"").length >= 1){
						self.parent().children(".replyClickResult").children("div").eq(1).children("#reply_create").attr("disabled",false);
						self.parent().children(".replyClickResult").children("div").eq(1).children("#reply_create").css({"color":"white","background-color":"slateblue"});
					}else{
						self.parent().children(".replyClickResult").children("div").eq(1).children("#reply_create").attr("disabled",true);
						self.parent().children(".replyClickResult").children("div").eq(1).children("#reply_create").css({"color":"#909090","background-color":"#0000000D"});
					}
				});
				self.parent().children(".replyClickResult").children("div").eq(1).children("#cancelBtn").on('click',function(){
					self.parent().children(".replyClickResult").html("");
					self.attr("name","boxing");
					self.attr("value","off");
				});
			});
		}
		if(self.val()=="off"){
			self.parent().children(".replyClickResult").css("display","block");
			self.attr("value","on");
		}else{
			self.parent().children(".replyClickResult").css("display","none");
			self.attr("value","off");
		}
	};
	
	var clickReply_reply = function(self){
		if(self.attr("name")=="boxing"){
			self.attr("name","unboxing");
			$.ajax({
				url: "/reply_replyForm",
				type: "GET",
			}).done(function(form){
				self.parent().children(".reply_replyClickResult").html(form);
				self.attr("value","on");
				var tagId = "@" + self.parent().parent().children(".reply_header").children("a").eq(1).children(".reply_user_id").text();
				self.parent().children(".reply_replyClickResult").children("div").eq(0).children("div").eq(1)
				.html("<a href='/userInfo?userid=" + self.parent().parent().children(".reply_header").children("a")
				.eq(1).children(".reply_user_id").text() + "'>@" + self.parent().parent().children(".reply_header")
				.children("a").eq(1).children(".reply_user_id").text() + "</a>&nbsp;");
				    var el = self.parent().children(".reply_replyClickResult").children("div").eq(0).children("div").eq(1)[0];
				    var range = document.createRange();
				    var sel = window.getSelection();
				    
				    range.setStart(el.childNodes[1], 1);
				    range.collapse(true);
				    
				    sel.removeAllRanges();
				    sel.addRange(range);

				var original = self.parent().children(".reply_replyClickResult").children("div").eq(0).children("div").eq(1).text().replace(/(\s*)/g,"");
				self.parent().children(".reply_replyClickResult").children("div").eq(0).children("div").eq(1).keyup(function(e){
					if($(this).children("a").text().trim() != tagId){
						$(this).children("a").remove();
					}
					var content = $(this).text();
					self.parent().children(".reply_replyClickResult").children("div").eq(1).children(".flu").children(".NOC").html('최대글자수: 1500/' + content.length);
					if(content.length > 1500){
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children(".flu").children(".alert").html('최대글자수를 초과했습니다!!');
					}else{
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children(".flu").children(".alert").html('');
					}
					if(content.replace(/(\s*)/g,"").length >= 1 && content.replace(/(\s*)/g,"") != original && content.length <= 1500){
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_reply_create").attr("disabled",false);
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_reply_create").css({"color":"white","background-color":"slateblue"});
					}else{
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_reply_create").attr("disabled",true);
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_reply_create").css({"color":"#909090","background-color":"#0000000D"});
					}
				});
				self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#cancelBtn").on('click',function(){
					self.parent().children(".reply_replyClickResult").html("");
					self.attr("name","boxing");
					self.attr("value","off");
				});
			});
		}
		if(self.val()=="off"){
			self.parent().children(".reply_replyClickResult").css("display","block");
			self.attr("value","on");
		}else{
			self.parent().children(".reply_replyClickResult").css("display","none");
			self.attr("value","off");
		}
	};
	
	return {
		clickMakeMyList:clickMakeMyList,
		clickAdd:clickAdd,
		clickUpdate:clickUpdate,
		clickDelete:clickDelete,
		clickReply:clickReply,
		clickReply_reply:clickReply_reply
	}
})();
