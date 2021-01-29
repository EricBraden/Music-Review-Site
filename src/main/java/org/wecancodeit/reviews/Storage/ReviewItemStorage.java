package org.wecancodeit.reviews.Storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Models.ReviewItem;
import org.wecancodeit.reviews.ReviewItemRepository;

@Service
public class ReviewItemStorage {
    private final ReviewItemRepository reviewItemRepo;

    public ReviewItemStorage(ReviewItemRepository reviewItemRepo) {
        this.reviewItemRepo = reviewItemRepo;
    }

    public void addReviewItem(ReviewItem inReviewItem){
        reviewItemRepo.save(inReviewItem);
    }

    public Iterable<ReviewItem> retrieveAllReviewItems(){
        return reviewItemRepo.findAll();
    }

    public ReviewItem retrieveReviewItemById(Long id) {
        return reviewItemRepo.findById(id).get();
    }
}
