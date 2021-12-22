

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
function printList(output) {
	var header = "<h2>" + output.reviews.length + " Reviews</h2><br>";
	var reviewObj;
	for (var i = 0; i < output.reviews.length; i++) {
		reviewObj = output.reviews[i];
		header += "<div id='" + reviewObj.multiId.user.id + "'>"
			+ "<div class='review_header'><a href='/userDetail/" + reviewObj.multiId.user.id + "'><img src='"
			+ reviewObj.multiId.user.photo + "'></a><span class='user_id'><a href='/userDetail'>"
			+ reviewObj.multiId.user.id + "</a></span><span class='update_date'>"
			+ new Date(reviewObj.updateDate).getFullYear() + ". "
			+ (new Date(reviewObj.updateDate).getMonth()+1) + ". "
			+ new Date(reviewObj.updateDate).getDate()
			+ "</span><span class='rating'><span class='smallFont'>평점: </span>" + reviewObj.rating.toFixed(1) + "</span></div>"
			+ "<div class='review_body'><pre>" + reviewObj.content + "</pre></div>"
			+ "<div class='review_footer'>" 
				+ "<button class='like'>" 
					+ "<img src='images/icon/thumbsUp.png' width=16px; height=16px>" 
				+ "</button>" 
				+ "<div class='likeCount'>" + output.likeCount[reviewObj.multiId.user.id] + "</div>" 
				+ "<button class='dislike'>" 
					+ "<img src='images/icon/thumbsDown.png' width=16px; height=16px>" 
				+ "</button>" 
				+ "<div class='disLikeCount'></div>" 
				+ "<button class='reply'>답글</button>" 
			+ "</div>"
			+ "</div>"
		$(".reviews").html(header);
	}
}