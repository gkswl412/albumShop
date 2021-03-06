

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
		+ '<span style="font-size:15px; color:black; font-weight:bold">' + totalPlayTime + '</span>' + '</li>');
}

/* albumDetailPage 리뷰 목록 출력 method */
function printList(output) {
	var header = "<h2>" + output.reviews.length + " Reviews</h2><br>";
	var reviewObj;
	var averageRating = 0;
	for (var i = 0; i < output.reviews.length; i++) {
		reviewObj = output.reviews[i];
		var likeCnt;
		var disLikeCnt;
		var thumbUpImgUrl = "images/icon/thumbsUp.png";
		var thumbDownImgUrl = "images/icon/thumbsDown.png";
		var likeOnOff = "off";
		var disLikeOnOff = "off";
		var replyCount=0;
		
		averageRating += parseInt(reviewObj.rating.toFixed(1));
		
		for(const key in output.likedReviewList){
			if(output.likedReviewList[key]==reviewObj.multiId.user.id){
				thumbUpImgUrl = "images/icon/thumbsUpFilled.png";
				likeOnOff = "on";
			}
		}
		for(const key in output.disLikedReviewList){
			if(output.disLikedReviewList[key]==reviewObj.multiId.user.id){
				thumbDownImgUrl = "images/icon/thumbsDownFilled.png";
				disLikeOnOff = "on";
			}
		}
		for(const key in output.replyCount){
			if(key==reviewObj.multiId.user.id){
				replyCount = output.replyCount[key];
			}
		}
		if(output.likeCount[reviewObj.multiId.user.id]==undefined){
			likeCnt = 0;
		}else{
			likeCnt = output.likeCount[reviewObj.multiId.user.id];
		}
		if(output.disLikeCount[reviewObj.multiId.user.id]==undefined){
			disLikeCnt = 0;
		}else{
			disLikeCnt = output.disLikeCount[reviewObj.multiId.user.id];
		}
		header += "<div id='" + reviewObj.multiId.user.id + "'>"
			+ "<div class='review_header'><a href='/userInfo?userid=" + reviewObj.multiId.user.id + "'><img src='/images/userProfile/"
			+ reviewObj.multiId.user.photo + "'></a><span class='user_id'><a href='/userInfo?userid=" + reviewObj.multiId.user.id + "'>"
			+ reviewObj.multiId.user.id + "</a></span><span class='update_date'>"
			+ new Date(reviewObj.updateDate).getFullYear() + ". "
			+ (new Date(reviewObj.updateDate).getMonth()+1) + ". "
			+ new Date(reviewObj.updateDate).getDate()
			+ "</span><span class='rating'><span class='smallFont'>평점: </span>" + reviewObj.rating.toFixed(1) + "</span></div>"
			+ "<div class='review_body'><pre>" + reviewObj.content + "</pre></div>"
			+ "<div class='review_footer'>" 
				+ "<button class='like' value='" + likeOnOff + "'>"
					+ "<img src='" + thumbUpImgUrl + "' width=15px; height=15px>" 
				+ "</button>" 
				+ "<div class='likeCount'>" + likeCnt + "</div>" 
				+ "<button class='disLike' value='" + disLikeOnOff + "'>" 
					+ "<img src='" + thumbDownImgUrl + "' width=15px; height=15px>" 
				+ "</button>" 
				+ "<div class='disLikeCount'>" + disLikeCnt + "</div>" 
				+ "<button class='reply' value='off' name='boxing'>답글</button><br>"
				+ "<div class='replyClickResult'></div>" 
				+ "<div class='replyZone'>" + "<button class='replyList' value='off' name='boxing'>답글 " + replyCount + "개 보기</button><br><div class='replyContent'></div>" + "</div>"
			+ "</div>"
			+ "</div>";
	}
	averageRating = (averageRating / output.reviews.length).toFixed(1);
	$(".averageRating").text(averageRating);
	$(".reviews").html(header);
}
