package thesis.saephaw.imusic.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewMusicRequest {

    private String title;
    private String description;
    private String imageUrl;
    private String url;
    private String musicCategoryId;
    private String musicArtistId;

}
