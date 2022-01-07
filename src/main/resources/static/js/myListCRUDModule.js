
var myListManager = (function(){
	
	var makeMyList = function(self){
		if(self.parent().children("#myListTitle").val() <= 0){
			alert("리스트 이름은 필수 입력 사항 입니다.");
		}else{
			$.ajax({
				url:"/makeMyList",
				type:"post",
				data:{
					"myListTitle":self.parent().children("#myListTitle").val()
				}
			}).done(function(myList){
				self.parent().parent().children("div").eq(1).children("ul").append("<li><input class='checkbox' type='checkbox' value='" + myList.id + "'>&nbsp;" + myList.myListTitle + "</li>");
			});
		}
	};
	
	var insertAlbum = function(albumId,myListId){
		$.ajax({
			url:"/mylist/insert-album/" + albumId + "/" + myListId,
			type:"post"
		}).done(function(album){
			console.log(album.title);
		});
	}
	
	var deleteAlbum = function(albumId,myListId){
		$.ajax({
			url:"/mylist/delete-album/" + albumId + "/" + myListId,
			type:"delete"
		}).done(function(album){
			console.log(album.title);
		});
	}
	
	return {
		makeMyList:makeMyList,
		insertAlbum:insertAlbum,
		deleteAlbum:deleteAlbum
	}
	
})();