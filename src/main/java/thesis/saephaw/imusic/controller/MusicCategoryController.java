package thesis.saephaw.imusic.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thesis.saephaw.imusic.entity.MusicCategory;
import thesis.saephaw.imusic.repo.MusicCategoryRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/music-categories")
public class MusicCategoryController {

    private final MusicCategoryRepo musicCategoryRepo;

    @PostMapping
    MusicCategory addMusicCategory(@RequestBody MusicCategory musicCategory) {
        return musicCategoryRepo.save(musicCategory);
    }

    @RequestMapping
    List<MusicCategory> getMusicCategories() {
        return musicCategoryRepo.findAll();
    }

}
