package thesis.saephaw.imusic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Music {

    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private String url;
    private boolean favorite;

    @DBRef
    private MusicCategory musicCategory;

    @DBRef
    private Artists artists;

}