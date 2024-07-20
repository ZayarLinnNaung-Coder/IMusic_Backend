package thesis.saephaw.imusic.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import thesis.saephaw.imusic.entity.Artists;

public interface ArtistRepo extends MongoRepository<Artists, String> {
}
