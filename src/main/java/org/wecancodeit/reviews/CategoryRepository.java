package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
