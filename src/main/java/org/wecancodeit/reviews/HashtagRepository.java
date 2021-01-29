package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Hashtag;

@Repository
public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
}
