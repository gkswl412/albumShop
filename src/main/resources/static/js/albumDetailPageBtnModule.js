/**
 * 
 */
var btnManager = (function(){
	
	var clickAdd = function(userId,albumId){
		if($("#addReviewBtn").val()=="off"){
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
			$("#addReviewBtn").attr("value","on");
		}else{
			$("#btnClickResult").html("");
			$("#addReviewBtn").attr("value","off");
		}
	};
	
	var clickUpdate = function(userId,albumId){
		if($("#updateReviewBtn").val()=="off"){
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
			$("#updateReviewBtn").attr("value","on");
		}else{
			$("#btnClickResult").html("");
			$("#updateReviewBtn").attr("value","off");
		}
	};
	
	var clickDelete = function(){
		
	};
	
	return {
		clickAdd:clickAdd,
		clickUpdate:clickUpdate,
		clickDelete:clickDelete
	}
})();
