/**
 * 
 */
var reviewManager = (function(){
	
	var getAll = function(obj, callback){
		console.log("get all...");
		$.getJSON('/review/'+obj,callback);
	};
	
	var create = function(obj, callback){
		console.log("create...");
	};
	
	var update = function(obj, callback){
		console.log("update.....");
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