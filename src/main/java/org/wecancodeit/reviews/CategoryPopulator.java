package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.Comment;
import org.wecancodeit.reviews.Models.Hashtag;
import org.wecancodeit.reviews.Models.ReviewItem;
import org.wecancodeit.reviews.Storage.CategoryStorage;
import org.wecancodeit.reviews.Storage.CommentStorage;
import org.wecancodeit.reviews.Storage.HashtagStorage;
import org.wecancodeit.reviews.Storage.ReviewItemStorage;

@Component
public class CategoryPopulator implements CommandLineRunner {
    private final CategoryStorage categoryStorage;
    private final ReviewItemStorage reviewItemStorage;
    private final HashtagStorage hashtagStorage;
    private final CommentStorage commentStorage;

    public CategoryPopulator(
            CategoryStorage categoryStorage,
            ReviewItemStorage reviewItemStorage,
            HashtagStorage hashtagStorage,
            CommentStorage commentStorage) {
        this.categoryStorage = categoryStorage;
        this.reviewItemStorage = reviewItemStorage;
        this.hashtagStorage = hashtagStorage;
        this.commentStorage = commentStorage;
    }

    @Override
    public void run(String... args) throws Exception{

        Category pop = new Category("Pop");
        Category country = new Category("Country");
        Category spiritual = new Category("Spiritual");
        categoryStorage.addCategory(pop);
        categoryStorage.addCategory(country);
        categoryStorage.addCategory(spiritual);

        Hashtag party = new Hashtag("#Party");
        Hashtag fedup = new Hashtag("#FedUp");
        Hashtag nativeamerican = new Hashtag("#NativeAmerian");
        hashtagStorage.addHashtag(party);
        hashtagStorage.addHashtag(fedup);
        hashtagStorage.addHashtag(nativeamerican);

        ReviewItem reviewMichaelJacksonThriller = new ReviewItem(
                "Thriller",
                "Michael Jackson",
                "Thriller is full of classics - can't have a party without it!",
                "Sony Music",
                "1982",
                "compact disc",
                "Paris, France",
                "https://www.amazon.com/Thriller-Michael-Jackson/dp/B00VSHH9GC/ref=sr_1_1?dchild=1&keywords=michael+jackson+thriller&qid=1609875857&sr=8-1",
                "https://www.worldcat.org/title/thriller/oclc/743105073&referer=brief_results",
                pop,
                party
        );
        ReviewItem reviewDollyParton9to5andOddJobs = new ReviewItem(
                "9 to 5 and Odd Jobs",
                "Dolly Parton",
                "9-5 was a delightful movie and even better song! Love Dolly and her knack for song writing.",
                "Buddha Records and BMG Distribution ",
                "1980",
                "compact disc",
                "New York, NY",
                "https://www.amazon.com/9-to-5/dp/B0013G4240/ref=sr_1_4?dchild=1&keywords=dolly+9+to+5+fed+up&qid=1609875824&sr=8-4",
                "https://www.worldcat.org/title/dolly-9-to-5-and-odd-jobs/oclc/43896783&referer=brief_results",
                country,
                fedup
        );
        ReviewItem reviewOliverShantiCirclesOfLife = new ReviewItem(
                "Best Of Oliver Shanti & Friends: Circles Of Life",
                "Oliver Shanti",
                "This is a wonderful collection of relaxing spiritual music inspired by Native American and Asian cultures.",
                "Shanti Records",
                "1997",
                "compact disc",
                "Portugal",
                "https://www.amazon.com/Best-Oliver-Shanti-Friends-Circles/dp/B004LLJ6PE/ref=sr_1_1?dchild=1&keywords=best+of+oliver+shanti&qid=1611599323&sr=8-1",
                "https://www.worldcat.org/title/circles-of-life-best-of-oliver-shanti-friends/oclc/781316934&referer=brief_results",
                spiritual,
                nativeamerican
                );
        reviewItemStorage.addReviewItem(reviewMichaelJacksonThriller);
        reviewItemStorage.addReviewItem(reviewDollyParton9to5andOddJobs);
        reviewItemStorage.addReviewItem(reviewOliverShantiCirclesOfLife);

        commentStorage.addComment(new Comment(reviewMichaelJacksonThriller, "I totally agree. MJ is a legend and his works are classics!"));
        commentStorage.addComment(new Comment(reviewDollyParton9to5andOddJobs, "Same. It's good music."));
        commentStorage.addComment(new Comment(reviewOliverShantiCirclesOfLife, "I recommend it too. This music is very calming"));
    }
}
