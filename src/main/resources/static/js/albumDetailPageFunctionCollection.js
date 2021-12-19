

/* albumDetailPage Track들의 총 재생시간 계산 method */
function calcTotalPlayTime() {
	var second = 0;
	$("#track li").each(function(index, item) {
		second += item.value;
	});
	var totalPlayTime = parseInt(second / 60) + ":" + second % 60;
	$("#track").append('<li class="list-group-item" id="totalPlayTime">'
		+ '<span></span>'
		+ '<span>' + '총 재생 시간:' + '</span>'
		+ '<span>' + totalPlayTime + '</span>' + '</li>');
}

/* albumDetailPage 리뷰 목록 출력 method */
function printList(list) {
	var header = "<h2>" + list.length + " Reviews</h2><br>";
	var reviewObj;
	for (var i = 0; i < list.length; i++) {
		reviewObj = list[i];
		header += "<div class='review_header'><a href='/userDetail/" + reviewObj.multiId.user.id + "'><img src='"
			+ reviewObj.multiId.user.photo + "'></a><span class='user_id'><a href='/userDetail'>"
			+ reviewObj.multiId.user.id + "</a></span><span class='update_date'>"
			+ new Date(reviewObj.updateDate).getFullYear() + ". "
			+ new Date(reviewObj.updateDate).getMonth() + ". "
			+ new Date(reviewObj.updateDate).getDay()
			+ "</span><span class='rating'><span class='smallFont'>평점: </span>" + reviewObj.rating.toFixed(1) + "</span></div>"
			+ "<div class='review_body'><pre>" + reviewObj.content + "</pre></div><br>";
			console.log(reviewObj.content);
		$(".reviews").html(header);
	}
}