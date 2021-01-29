package org.wecancodeit.reviews.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Storage.HashtagStorage;

@Controller
public class HashtagController {
    HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
            this.hashtagStorage = hashtagStorage;
        }

    @RequestMapping("allHashtags")
    public String displayAllHashtags(Model model) {
        model.addAttribute("allHashtags", hashtagStorage.retrieveAllHashtags());
        return"hashtags-template";
    }
    @GetMapping("hashtags/{id}")
    public String displayOneHashtagsItems(Model model, @PathVariable Long id){
        model.addAttribute("allHashtags", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("thisHashtagsReviews", hashtagStorage.retrieveHashtagById(id).getListOfReviewItems());
        model.addAttribute("thisHashtagsName", hashtagStorage.retrieveHashtagById(id).getName());
        System.out.println(hashtagStorage.retrieveHashtagById(id).getName());
        return "ReviewsByHashtag-template";
    }


}

