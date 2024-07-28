package thesis.saephaw.imusic.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import thesis.saephaw.imusic.entity.Music;

import java.util.List;

public interface MusicRepo extends MongoRepository<Music, String> {

    @Query("{ 'artists.id': ?0 }")
    List<Music> findByArtistId(String artistId);

    List<Music> findByFavorite(boolean favorite);

}
