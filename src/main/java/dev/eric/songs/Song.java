package dev.eric.songs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "songCollection")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    private ObjectId id;
    private String trackName;
    private String artist_names;
    private String link;
    private String Poster;
    private String source;
    private int rank;
    private int peak_rank;
    private int previous_rank;
    private int weeks_on_chart;
    private double streams;

    @DocumentReference  // put reviews in a seperate collection on MongoDB
    private List<Review> reviewIds; // W/0 DocumentReference, Embedded relationship all related reviews to movie will be to this list.

}
