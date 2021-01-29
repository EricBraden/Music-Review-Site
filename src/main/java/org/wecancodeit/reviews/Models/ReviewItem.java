package org.wecancodeit.reviews.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ReviewItem {
    @Id
    @GeneratedValue
    private Long id;
    private String albumName;
    private String artist;
    private String review;
    private String publisher;
    private String dateOfPublication;
    private String format;
    private String locationPublished;
    private String amazonLink;
    private String worldCatLink;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @OneToMany(mappedBy = "reviewItem")
    private Collection<Comment> comments;

    public ReviewItem(
            String albumName,
            String artist,
            String review,
            String publisher,
            String dateOfPublication,
            String format,
            String locationPublished,
            String amazonLink,
            String worldCatLink,
            Category category,
            Hashtag...hashtags) {
            this.albumName = albumName;
            this.artist = artist;
            this.review = review;
            this.publisher = publisher;
            this.dateOfPublication = dateOfPublication;
            this.format = format;
            this.locationPublished = locationPublished;
            this.amazonLink = amazonLink;
            this.worldCatLink = worldCatLink;
            this.category = category;
            this.hashtags = List.of(hashtags);
    }

    public ReviewItem(){}

    public Long getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtist() {
        return artist;
    }

    public String getReviews() {
        return review;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public String getFormat() {
        return format;
    }

    public String getLocationPublished() {
        return locationPublished;
    }

    public String getAmazonLink() {
        return amazonLink;
    }

    public String getWorldCatLink() {
        return worldCatLink;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public String getAllReviews() {
        return review;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void addHashtags(Hashtag inHashtag) {
        this.hashtags.add(inHashtag);
    }

    public void addComment(Comment inComment){
        this.comments.add(inComment);
    }

    public boolean checkForExistingHashtag(Hashtag inHashtag, String newHashtagsName){
        return this.hashtags.stream().map(Hashtag::getName).filter(newHashtagsName::equals).findFirst().isPresent();
    }

    @Override
    public String toString() {
        return "ReviewItem{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", artist='" + artist + '\'' +
                ", review='" + review + '\'' +
                ", publisher='" + publisher + '\'' +
                ", dateOfPublication='" + dateOfPublication + '\'' +
                ", format='" + format + '\'' +
                ", locationPublished='" + locationPublished + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                ", worldCatLink='" + worldCatLink + '\'' +
                '}';
    }

}