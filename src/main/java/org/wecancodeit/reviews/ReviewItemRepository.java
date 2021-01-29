package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.ReviewItem;

@Repository
public interface ReviewItemRepository extends CrudRepository<ReviewItem, Long> {
}
