/**
 * 
 */
var btnManager = (function(){
	
	var clickAdd = function(userId,albumId){	
		if($("#addReviewBtn").val()=="off"){
			$("#addReviewBtn").attr("value","on");
			$("#updateReviewBtn").attr("value","off");
			$("#deleteReviewBtn").attr("value","off");
			$.ajax({
				url: "/writeReviewForm",
				type: "GET",
				data:{
					"albumId":albumId,
					"userId":userId,
					"job":"create"
				}
			}).done(function(form){
				$("#btnClickResult").html(form);
			});
		}else{
			$("#addReviewBtn").attr("value","off");
			$("#btnClickResult").html("");
		}
	};
	
	var clickUpdate = function(userId,albumId){
		if($("#updateReviewBtn").val()=="off"){
			$("#updateReviewBtn").attr("value","on");
			$("#addReviewBtn").attr("value","off");
			$("#deleteReviewBtn").attr("value","off");
			$.ajax({
				url: "/writeReviewForm",
				type: "GET",
				data:{
					"albumId":albumId,
					"userId":userId,
					"job":"update"
				}
			}).done(function(form){
				$("#btnClickResult").html(form);
			});
		}else{
			$("#updateReviewBtn").attr("value","off");
			$("#btnClickResult").html("");
		}
	};
	
	var clickDelete = function(userId,albumId){
		if($("#deleteReviewBtn").val()=="off"){
			$("#deleteReviewBtn").attr("value","on");
			$("#addReviewBtn").attr("value","off");
			$("#updateReviewBtn").attr("value","off");
			$.ajax({
				url: "/writeReviewForm",
				type: "GET",
				data:{
					"albumId":albumId,
					"userId":userId,
					"job":"delete"
				}
			}).done(function(form){
				$("#btnClickResult").html(form);
			});
		}else{
			$("#deleteReviewBtn").attr("value","off");
			$("#btnClickResult").html("");
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
					if(content.length >= 1){
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
				url: "/replyForm",
				type: "GET",
			}).done(function(form){
				self.parent().children(".reply_replyClickResult").html(form);
				self.attr("value","on");
				self.parent().children(".reply_replyClickResult").children("div").eq(0).children("div").eq(1).children("#textarea").keyup(function(e){
					var content = $(this).val();
					if(content.length >= 1){
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_create").attr("disabled",false);
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_create").css({"color":"white","background-color":"slateblue"});
					}else{
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_create").attr("disabled",true);
						self.parent().children(".reply_replyClickResult").children("div").eq(1).children("#reply_create").css({"color":"#909090","background-color":"#0000000D"});
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
		clickAdd:clickAdd,
		clickUpdate:clickUpdate,
		clickDelete:clickDelete,
		clickReply:clickReply,
		clickReply_reply:clickReply_reply
	}
})();
