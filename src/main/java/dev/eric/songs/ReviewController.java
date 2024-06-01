package dev.eric.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    // One post method
    @Autowired
    private ReviewService reviewService;

    // Called by client as POST. This adds to out database
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("trackName")), HttpStatus.CREATED);
    }
    @GetMapping("/song/{trackName}") //GetMapping method that maps to the URL /api/v1/reviews/song/{trackName}
    public ResponseEntity<List<Review>> getAllReviewsForSong(@PathVariable String trackName) {
        List<Review> reviews = reviewService.getAllReviewsForSong(trackName);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
