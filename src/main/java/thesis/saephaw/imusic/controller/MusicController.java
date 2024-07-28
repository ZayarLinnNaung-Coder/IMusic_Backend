package thesis.saephaw.imusic.controller;

import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import thesis.saephaw.imusic.domain.FavMusicRequest;
import thesis.saephaw.imusic.domain.NewMusicRequest;
import thesis.saephaw.imusic.entity.Artists;
import thesis.saephaw.imusic.entity.Music;
import thesis.saephaw.imusic.entity.MusicCategory;
import thesis.saephaw.imusic.repo.ArtistRepo;
import thesis.saephaw.imusic.repo.MusicCategoryRepo;
import thesis.saephaw.imusic.repo.MusicRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/musics")
@CrossOrigin
public class MusicController {

    private final MusicRepo musicRepo;
    private final ArtistRepo artistRepo;
    private final MusicCategoryRepo musicCategoryRepo;

    @GetMapping
    List<Music> getAllMusic(@RequestParam(required = false) String artistId) {

        if(StringUtils.hasText(artistId)){
            return musicRepo.findByArtistId(artistId);
        }

        return musicRepo.findAll();
    }

    @PostMapping
    Music addMusic(@RequestBody NewMusicRequest music) {

        MusicCategory musicCategory = musicCategoryRepo.findById(music.getMusicCategoryId()).get();
        Artists artists = artistRepo.findById(music.getMusicArtistId()).get();

        Music musicEntity = new Music();
        musicEntity.setTitle(music.getTitle());
        musicEntity.setDescription(music.getDescription());
        musicEntity.setImageUrl(music.getImageUrl());
        musicEntity.setUrl(music.getUrl());
        musicEntity.setMusicCategory(musicCategory);
        musicEntity.setArtists(artists);

        return musicRepo.save(musicEntity);
    }

    @GetMapping("{id}")
    Music getMusicById(@PathVariable String id) {
        return musicRepo.findById(id).get();
    }

    @GetMapping("fav")
    List<Music> getAllFavoriteMusic() {
        return musicRepo.findByFavorite(true);
    }

    @PostMapping("fav/{id}")
    void makeFavorite(@PathVariable String id, @RequestBody FavMusicRequest request) {

        Music music = musicRepo.findById(id).get();
        music.setFavorite(request.isFavorite());
        musicRepo.save(music);
    }

}