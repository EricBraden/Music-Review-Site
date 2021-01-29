package org.wecancodeit.reviews.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany(mappedBy = "hashtags")
    private final Collection<ReviewItem> reviewItems = new ArrayList<ReviewItem>();

    public Hashtag() {
    }

    public Hashtag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<ReviewItem> getListOfReviewItems() {
        return reviewItems;
    }

    public void addReviewItem(ReviewItem inReviewItem){
        this.reviewItems.add(inReviewItem);
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != hashtag.id) return false;
        return name != null ? name.equals(hashtag.name) : hashtag.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
