package thesis.saephaw.imusic.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thesis.saephaw.imusic.entity.Artists;
import thesis.saephaw.imusic.repo.ArtistRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistRepo artistRepo;

    @PostMapping
    Artists addArtist(@RequestBody Artists artist) {
        return artistRepo.save(artist);
    }

    @RequestMapping
    List<Artists> getAllArtists() {
        return artistRepo.findAll();
    }   

}
