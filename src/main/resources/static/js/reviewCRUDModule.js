
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
	
	var clickThumb = function(userId, albumId, job, callback){
		$.ajax({
			type:"post",
			url:'review/thumb/' + userId + '/' + albumId + '/' + job,
			success:callback
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