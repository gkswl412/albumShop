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
	
	var passcheck = function(userid,pass){
		$.ajax({
			url:"/PassWordChangeForm",
			type:"POST",
			data:{
				"id":userid,
				"pass":pass,
				"job":"update"
			}
		}).done(function(form){
			$("#here1").html(form);
		});
	};
	var passchange = function(userid, pass){
	$.ajax({
	type:"POST",
	url:"/passchange",
	data: {
	"id" : userid,
	"pass" : pass,
	}
	}).done(function(form){
	$("#here1").html("");
	})
	};
	
	
	var addressch = function(id){
	$.ajax({
		url:"/AddressChangeForm",
		type:"GET",
		data:{
		"id":id,
		"job":"update"
		}
	}).done(function(form){
	$("#here2").html(form);
	});
	};
	return{
	clicklist: clicklist,
	passcheck: passcheck,
	addressch: addressch,
	passchange: passchange
	}
	
	
	
	
})();



