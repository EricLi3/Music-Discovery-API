package dev.eric.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> findByTrackName(String track_nameId){
        return songRepository.findSongByTrackName(track_nameId);
    }
}
