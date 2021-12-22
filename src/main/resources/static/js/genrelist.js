/**
 * 
 */
var genreList = (function() {
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
	return{
	clicklist: clicklist
	}
})();
