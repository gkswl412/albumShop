/**
 * 
 */
var reviewManager = (function(){
	
	var getAll = function(obj, callback){
		console.log("get all...");
		$.getJSON('/review/'+obj,callback);
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
	};
	
	return {
		getAll: getAll,
		create: create,
		update: update,
		remove: remove
	}
	
})();