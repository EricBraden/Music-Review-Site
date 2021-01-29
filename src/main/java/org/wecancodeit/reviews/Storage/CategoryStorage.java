package org.wecancodeit.reviews.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.CategoryRepository;
import org.wecancodeit.reviews.Models.Category;

@Service
public class CategoryStorage {
    private final CategoryRepository categoryRepo;

    @Autowired
    public CategoryStorage(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(Category inCategory){
        categoryRepo.save(inCategory);
    }

    public Iterable<Category> retrieveAllCategories(){
        return categoryRepo.findAll();
    }

    public Category retrieveCategoryById(Long id) {
        return categoryRepo.findById(id).get();
    }
}
