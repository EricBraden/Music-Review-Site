package org.wecancodeit.reviews.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Models.Hashtag;
import org.wecancodeit.reviews.HashtagRepository;

@Service
public class HashtagStorage {
    private final HashtagRepository hashtagRepo;

    @Autowired
    public HashtagStorage(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public void addHashtag(Hashtag inHashtag){
        hashtagRepo.save(inHashtag);
    }

    public Iterable<Hashtag> retrieveAllHashtags(){
        return hashtagRepo.findAll();
    }

    public Hashtag retrieveHashtagById(Long id) {
        return hashtagRepo.findById(id).get();
    }
}
