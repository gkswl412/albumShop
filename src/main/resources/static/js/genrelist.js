/**
 * 
 */
var jsList = (function() {
	var clicklist = function(genre){
	console.log(genre);
		$.ajax({
		url: "/GenreListForm",
		type: "GET",
		data:{
			"genre":genre
			}
	}).done(function(form) {
			$("#here").html(form);
	});
	};
	
	var passcheck = function(id,pass){
		$.ajax({
			url:"/PassWordChangeForm",
			type:"POST",
			data:{
				"id":id,
				"pass":pass,
				"job":"update"
			}
			
		}).done(function(form){
			$("#here1").html(form);
		});
	
	};
	return{
	clicklist: clicklist,
	passcheck: passcheck
	}
	
	
	
	
})();



