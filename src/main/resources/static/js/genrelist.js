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
	
	var passcheckform = function(userid,pass){
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
	});
	};
	
	
	var addresschform = function(id){
	console.log(id);
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
	
	var address = function(id,addr){
	$.ajax({
		url:"/addresschange",
		type:"POST",
		data:{
		"id": id,
		"addr": addr
		}
	}).done(function(form){
	$("#here2").html("");
	});
	};
	
	var photochangeform = function(id,photo){
	$.ajax({
		url:"/PhotoChangeForm",
		type:"POST",
		data:{
		"id": id,
		"photo": photo
		}
	}).done(function(form){
	$("#here3").html(form);
	});
	
	};
	
	var mycartlist = function(id){
	$.ajax({
	url:"/MyCartList",
	type:"GET",
	data:{"id":id}
	}).done(function(form){
	$("#a1").html(form);
	});
	};
	
	var myalbumtitlelist = function(id){
	$.ajax({
	url:"/MyAlbumTitleList",
	type:"GET",
	data:{"id":id}
	}).done(function(form){
	$("#a1").html(form);
	});
	};
	
	var myalbumlist = function(id, mylisttitle){
	$.ajax({
	url:"/MyAlbumList",
	type:"GET",
	data:{
	"id":id,
	"mylisttitle":mylisttitle
	}
	}).done(function(form){
	$("#a2").html(form);
	});
	};
	
	
	return{
	clicklist: clicklist,
	passcheckform: passcheckform,
	addresschform: addresschform,
	passchange: passchange,
	address:address,
	photochangeform:photochangeform,
	mycartlist:mycartlist,
	myalbumtitlelist:myalbumtitlelist,
	myalbumlist:myalbumlist	
	}
	
})();



