package thesis.saephaw.imusic.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import thesis.saephaw.imusic.entity.MusicCategory;

public interface MusicCategoryRepo extends MongoRepository<MusicCategory, String> {
}
