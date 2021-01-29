package org.wecancodeit.reviews.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String comment;
    @ManyToOne
    private ReviewItem reviewItem;

    public Comment(ReviewItem reviewItem, String comment) {
        this.reviewItem = reviewItem;
        this.comment = comment;
    }

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (id != comment1.id) return false;
        return comment != null ? comment.equals(comment1.comment) : comment1.comment == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
