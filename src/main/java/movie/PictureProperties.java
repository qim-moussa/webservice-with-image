package movie;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by moussa on 16/11/15.
 */

@ConfigurationProperties("picture")
public class PictureProperties {

    private String backdropPath;
    private String posterPath;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
