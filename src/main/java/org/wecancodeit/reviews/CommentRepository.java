package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{


}