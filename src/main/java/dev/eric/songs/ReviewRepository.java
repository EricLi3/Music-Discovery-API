package dev.eric.songs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    // Add GET and DELETE functionalities here.
    List<Review> findAllByTrackName(String trackName);
}
