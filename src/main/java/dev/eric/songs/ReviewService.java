package dev.eric.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired  // allows for the POST to the database
    private ReviewRepository reviewRepository;

    @Autowired  // update to the movie class
    private MongoTemplate mongoTemplate;

    // Look for movie with imdbID, and associate a new review with that trackName
    public Review createReview(String reviewBody, String trackName){
        Review review = reviewRepository.insert(new Review(reviewBody, trackName));    // insert return data you pushed into database

        // Using template make an update on the movie class.
        mongoTemplate.update(Song.class)
                .matching(Criteria.where("trackName").is(trackName))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }
    // Get all Reviews associated with a track name
    public List<Review> getAllReviewsForSong(String trackName) {
        return reviewRepository.findAllByTrackName(trackName);
    }
}
