
/* review CRUD ajax Module */
var reviewManager = (function(){
	
	var getAll = function(obj, callback){
		console.log("get all...");
		$.getJSON('/review/' + obj, callback);
	};
	
	var create = function(obj, callback){
		var review = obj;
		console.log(review);
		$.ajax({
			type:"post",
			url:'review/'+ obj.multiId.album.id ,
			data: JSON.stringify(review),
			dataType:'json',
			contentType: "application/json",
			success:callback
		});
	};
	
	var update = function(obj, callback){
		var review = obj;
		console.log(review);
		$.ajax({
			type:"put",
			url:'review/'+ obj.multiId.album.id ,
			data: JSON.stringify(review),
			dataType:'json',
			contentType: "application/json",
			success:callback
		});
	};
	
	var remove = function(obj, callback){
		console.log("delete........");
		$.ajax({
			type:"delete",
			url:'review/' + obj.multiId.album.id + '/' + obj.multiId.user.id,
			success:callback
		});
	};
	
	var clickThumb = function(userId, albumId, job, self){
		$.ajax({
			type:"post",
			url:'review/thumb/' + userId + '/' + albumId + '/' + job,
			success:function(data){
				if(data.job=="like"){
					if(self.attr("value")=="off"){
						self.attr("value","on");
						self.children('img').attr("src","images/icon/thumbsUpFilled.png");
						self.parent().children('.disLike').children('img').attr("src","images/icon/thumbsDown.png");
						self.parent().children('.disLike').attr("value","off");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					}else{
						self.attr("value","off");
						self.children('img').attr("src","images/icon/thumbsUp.png");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					}
				}else{
					if(self.attr("value")=="off"){
						self.attr("value","on");
						self.children('img').attr("src","images/icon/thumbsDownFilled.png");
						self.parent().children('.like').children('img').attr("src","images/icon/thumbsUp.png");
						self.parent().children('.like').attr("value","off");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					}else{
						self.attr("value","off");
						self.children('img').attr("src","images/icon/thumbsDown.png");
						self.parent().children('.likeCount').html(data.likeCount);
						self.parent().children('.disLikeCount').html(data.disLikeCount);
					}
				}
				
				console.log(data.job);
				console.log(data.likeCount);
				console.log(data.disLikeCount);
				console.log(self);	
			}
		});
	};
	
	return {
		getAll: getAll,
		create: create,
		update: update,
		remove: remove,
		clickThumb: clickThumb
	}
	
})();