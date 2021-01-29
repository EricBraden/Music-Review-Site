package org.wecancodeit.reviews.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Storage.CategoryStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class CategoryController {
    private final CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("allCategories")
    public String displayAllCategories(Model model) {
        model.addAttribute("allCategories", sortCategoriesLexicographically());
        return "categories-template";
    }

    @GetMapping("categories/{id}")
    public String displayOneCategorysItems(Model model, @PathVariable Long id){
        model.addAttribute("allCategories", categoryStorage.retrieveAllCategories());
        model.addAttribute("thisCategoriesReviews", categoryStorage.retrieveCategoryById(id).getListOfReviewItems());
        model.addAttribute("thisCategoriesName", categoryStorage.retrieveCategoryById(id).getNameOfCategory());
        return "ReviewsByCategory-template";
    }

    private List<Category> sortCategoriesLexicographically() {
        List<Category> allCategories = new ArrayList<>();
        for(Category i: categoryStorage.retrieveAllCategories()){
            allCategories.add(i);
        }
        allCategories.sort(Comparator.comparing(Category::getNameOfCategory, String.CASE_INSENSITIVE_ORDER));
        return allCategories;
    }
}

