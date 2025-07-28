package com.example.JobPortalApplication.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review findReviewById(Long reviewId);
}
