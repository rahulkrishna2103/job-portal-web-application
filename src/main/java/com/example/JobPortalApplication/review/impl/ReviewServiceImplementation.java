package com.example.JobPortalApplication.review.impl;

import com.example.JobPortalApplication.company.Company;
import com.example.JobPortalApplication.company.CompanyRepository;
import com.example.JobPortalApplication.company.CompanyService;
import com.example.JobPortalApplication.review.Review;
import com.example.JobPortalApplication.review.ReviewRepository;
import com.example.JobPortalApplication.review.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {
    ReviewRepository reviewRepository;

    CompanyService companyService;

    public ReviewServiceImplementation(CompanyService companyService) {
        this.companyService = companyService;
    }

    public ReviewServiceImplementation(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReview(Long companyId){
        return reviewRepository.findByCompanyId(companyId);
    }

    public boolean addReview(Long companyId,Review review){
        Company company = companyService.findCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public Review findReviewById(Long reviewId){
        return reviewRepository.findById(reviewId).orElse(null);
    }
}
