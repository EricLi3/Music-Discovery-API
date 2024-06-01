package dev.eric.songs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * Data access Layer. Talking to teh database and getting the data back
 *
 * */
@Repository
public interface SongRepository extends MongoRepository<Song, ObjectId> {
    Optional<Song> findSongByTrackName(String track_name);
}
