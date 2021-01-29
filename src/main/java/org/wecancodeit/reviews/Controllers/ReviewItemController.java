package org.wecancodeit.reviews.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.Comment;
import org.wecancodeit.reviews.Models.Hashtag;
import org.wecancodeit.reviews.Models.ReviewItem;
import org.wecancodeit.reviews.Storage.CategoryStorage;
import org.wecancodeit.reviews.Storage.CommentStorage;
import org.wecancodeit.reviews.Storage.HashtagStorage;
import org.wecancodeit.reviews.Storage.ReviewItemStorage;
import java.util.*;

@Controller
public class ReviewItemController {
    CategoryStorage categoryStorage;
    ReviewItemStorage reviewItemStorage;
    HashtagStorage hashtagStorage;
    CommentStorage commentStorage;

    public ReviewItemController(CategoryStorage inCategoryStorage, ReviewItemStorage inReviewItemStorage, HashtagStorage inHashtagStorage, CommentStorage inCommentStorage) {
        categoryStorage = inCategoryStorage;
        reviewItemStorage = inReviewItemStorage;
        hashtagStorage = inHashtagStorage;
        commentStorage = inCommentStorage;
    }

    @RequestMapping({"","/","allReviews"})
    public String displayAllReviews(Model model) {

        model.addAttribute("allHashtags", sortHashtagsLexicographically());
        model.addAttribute("allReviews", reviewItemStorage.retrieveAllReviewItems());
        model.addAttribute("allCategories", sortCategoriesLexicographically());
        return"review-template";
    }

    @PostMapping("addCommentOnReview")
    public String addCommentOnReview(Model model, @RequestParam Long id, @RequestParam String newCommentToAdd) {
        if (newCommentToAdd.length()>0) {addCommentOnReview(id, newCommentToAdd);}
        return"redirect:allReviews";
    }

    @PostMapping("addHashtag")
    public String addHashtags(Model model, @RequestParam Long id, @RequestParam String newHashtagsToAdd) {
        addHashtags(id, newHashtagsToAdd);
        return"redirect:allReviews";
    }

    private void addCommentOnReview(Long id, String inCommentOnReview){
        Comment newComment = new Comment(reviewItemStorage.retrieveReviewItemById(id), inCommentOnReview);
        ReviewItem thisReviewItem;
        thisReviewItem = reviewItemStorage.retrieveReviewItemById(id);
        thisReviewItem.addComment(newComment);
        commentStorage.addComment(newComment);
    }

    private void addHashtags(Long id, String inOneRawStringOfAllHashtagsToAdd){
        ArrayList<String> listOfTagsToAdd = new ArrayList<>();
        ArrayList<String> listOfLowerCaseHashtagNamesToAdd = new ArrayList<>();
        String[] newStrings = inOneRawStringOfAllHashtagsToAdd.split("#|,| "); //makes array
        for (String i: newStrings){ //loops through all the new strings
            if (  //tests for and skips empty and non-hashtag strings
                i.equalsIgnoreCase("") ||
                i.equalsIgnoreCase(" ") ||
                i.equalsIgnoreCase(",") ||
                i.equalsIgnoreCase(".") ||
                i.equalsIgnoreCase("#") )
            {continue;} // skips non-hashtag strings
            else {
                i = i.replaceAll("[^a-zA-Z0-9]", ""); //removes all non alpha-numeric characters
                listOfTagsToAdd.add("#"+i); //adds strings to new hashtag list
                listOfLowerCaseHashtagNamesToAdd.add(i.toLowerCase());
            }
        }
        ReviewItem thisReviewItem;
        thisReviewItem = reviewItemStorage.retrieveReviewItemById(id);
        for (String i: listOfTagsToAdd){
            Hashtag newHashtag = new Hashtag(i);
            if (thisReviewItem.checkForExistingHashtag(newHashtag, newHashtag.getName())){continue;} //skips redundant hashtags
            thisReviewItem.addHashtags(newHashtag);
            hashtagStorage.addHashtag(newHashtag);
            newHashtag.addReviewItem(thisReviewItem);
        }
    }

    private List<Category> sortCategoriesLexicographically() {
        List<Category> allCategories = new ArrayList<>();
        for(Category i: categoryStorage.retrieveAllCategories()){
            allCategories.add(i);
        }
        allCategories.sort(Comparator.comparing(Category::getNameOfCategory, String.CASE_INSENSITIVE_ORDER));
        return allCategories;
    }

    private List<Hashtag> sortHashtagsLexicographically() {
        List<Hashtag> allHashtags = new ArrayList<>();
        for(Hashtag i: hashtagStorage.retrieveAllHashtags()){
            allHashtags.add(i);
        }
        allHashtags.sort(Comparator.comparing(Hashtag::getName, String.CASE_INSENSITIVE_ORDER));
        return allHashtags;
    }
}
