package org.albumshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.MultiIdUserReviewReply;
import org.albumshop.domain.ReviewReply;
import org.albumshop.domain.ReviewReplyDisLike;
import org.albumshop.domain.ReviewReplyLike;
import org.albumshop.domain.User;
import org.albumshop.persistence.ReviewReplyDisLikeRepository;
import org.albumshop.persistence.ReviewReplyLikeRepository;
import org.albumshop.persistence.ReviewReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	
	@Autowired
	ReviewReplyRepository replyRepo;
	@Autowired
	ReviewReplyLikeRepository repleLikeRepo;
	@Autowired
	ReviewReplyDisLikeRepository repleDisLikeRepo;
	@Autowired
	private HttpSession session;
	
	//Reply 목록 가져오기
	public Map<String, Object> getReplies(Long albumId, String userId){
		Map<String, Object> result = new HashMap<>();
		List<ReviewReply> replies = new ArrayList<>();
		Map<Long, Long> likeCount = getLikeCount(albumId, userId);
		Map<Long, Long> disLikeCount = getDisLikeCount(albumId, userId);
		replyRepo.findByReviewMultiIdAlbumIdAndReviewMultiIdUserId(albumId, userId).forEach(reply->{
			replies.add(reply);
		});
		User user = (User) session.getAttribute("user");
		if(user != null) {
			List<Long> likedReplyList = getLikedReplyList(albumId, userId, user.getId());
			List<Long> disLikedReplyList = getDisLikedReplyList(albumId, userId, user.getId());
			result.put("likedReplyList", likedReplyList);
			result.put("disLikedReplyList", disLikedReplyList);
			result.put("userId", user.getId());
		}
		result.put("replies", replies);
		result.put("likeCount", likeCount);
		result.put("disLikeCount", disLikeCount);
		return result;
	}
	
	//댓글별 좋아요 개수 가져오기
	public Map<Long, Long> getLikeCount(Long albumId, String userId){
		Map<Long, Long> likeCountPerReply = new HashMap<>();
		repleLikeRepo.getLikeCountPerReplyInReview(albumId, userId).forEach(item->{
			likeCountPerReply.put( (Long) item[0], (Long) item[1] );
		});
		return likeCountPerReply;
	}
	
	//댓글별 싫어요 개수 가져오기
	public Map<Long, Long> getDisLikeCount(Long albumId, String userId){
		Map<Long, Long> disLikeCountPerReply = new HashMap<>();
		repleDisLikeRepo.getDisLikeCountPerReplyInReview(albumId, userId).forEach(item->{
			disLikeCountPerReply.put( (Long) item[0], (Long) item[1] );
		});
		return disLikeCountPerReply;
	}
	
	//좋아요 표시한 댓글 얻기
	public List<Long> getLikedReplyList(Long reviewAlbumId, String reviewUserId, String userId){
		return repleLikeRepo.getLikedReplyList(reviewAlbumId, reviewUserId, userId);
	}
	
	//싫어요 표시한 댓글 얻기
	public List<Long> getDisLikedReplyList(Long reviewAlbumId, String reviewUserId, String userId){
		return repleDisLikeRepo.getDisLikedReplyList(reviewAlbumId, reviewUserId, userId);
	}
	
	//공감 비공감 테이블 확인
	public Map<String, Object> checkEmpathyTable(Long replyId, String job){
		ReviewReply reviewReply = replyRepo.findById(replyId).get();
		User user = (User) session.getAttribute("user");
		MultiIdUserReviewReply replyEmpathyId = new MultiIdUserReviewReply();
		replyEmpathyId.setId(user.getId(), replyId);
		if(job.equals("like")) {
			repleLikeRepo.findById(replyEmpathyId).ifPresentOrElse(repleLike->{
				repleLikeRepo.delete(repleLike);
			}, ()->{
				repleDisLikeRepo.findById(replyEmpathyId).ifPresentOrElse(repleDisLike->{
					repleDisLikeRepo.delete(repleDisLike);
					repleLikeRepo.save(ReviewReplyLike.builder().multiId(replyEmpathyId).build());
				}, ()->{
					repleLikeRepo.save(ReviewReplyLike.builder().multiId(replyEmpathyId).build());
				});
			});
		}else {
			repleLikeRepo.findById(replyEmpathyId).ifPresentOrElse(repleLike->{
				repleLikeRepo.delete(repleLike);
				repleDisLikeRepo.save(ReviewReplyDisLike.builder().multiId(replyEmpathyId).build());
			}, ()->{
				repleDisLikeRepo.findById(replyEmpathyId).ifPresentOrElse(repleDislike->{
					repleDisLikeRepo.delete(repleDislike);
				}, ()->{
					repleDisLikeRepo.save(ReviewReplyDisLike.builder().multiId(replyEmpathyId).build());
				});
			});
		}
		Map<String, Object> output = new HashMap<>();
		output.put("job", job);
		output.put("likeCount", repleLikeRepo.countByMultiIdReviewReply(reviewReply));
		output.put("disLikeCount", repleDisLikeRepo.countByMultiIdReviewReply(reviewReply));
		return output;
	}

	public void createReply(ReviewReply reply) {
		User user = (User) session.getAttribute("user");
		reply.setUser(user);
		replyRepo.save(reply);
	}

	public void deleteReply(Long replyId) {
		replyRepo.findById(replyId).ifPresentOrElse(reply->{
			replyRepo.delete(reply);
		}, ()->{
			System.out.println("해당 댓글은 존재하지 않습니다.");
		});
	}

	public void updateReply(Long replyId, String content) {
		replyRepo.findById(replyId).ifPresentOrElse(reply->{
			reply.setContent(content);
			replyRepo.save(reply);
		}, ()->{
			System.out.println("해당 댓글은 존재하지 않습니다.");
		});
	}
}
