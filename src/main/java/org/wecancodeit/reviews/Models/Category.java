package org.wecancodeit.reviews.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String nameOfCategory;
    @OneToMany(mappedBy = "category")
    private final Collection<ReviewItem> listOfReviewItems = new ArrayList<>();

    public Category(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public Collection<ReviewItem> getListOfReviewItems() {
        return listOfReviewItems;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        return nameOfCategory != null ? nameOfCategory.equals(category.nameOfCategory) : category.nameOfCategory == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nameOfCategory != null ? nameOfCategory.hashCode() : 0);
        return result;
    }
}
