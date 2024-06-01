package dev.eric.songs;

// Rest API layer - Controller. uses movie service class to get what it wants, and giving it back
// to the API layer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs(){
        return new ResponseEntity<List<Song>>(songService.allSongs(), HttpStatus.OK);
    }

    @GetMapping("/{trackName}")
    public ResponseEntity<Optional<Song>> getSingleSong(@PathVariable String trackName){
        return new ResponseEntity<Optional<Song>>(songService.findByTrackName(trackName), HttpStatus.OK);
    }

}
