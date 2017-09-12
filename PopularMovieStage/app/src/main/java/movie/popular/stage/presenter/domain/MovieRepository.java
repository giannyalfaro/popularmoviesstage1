package movie.popular.stage.presenter.domain;

/**
 * Created by s3081865 on 11/09/2017.
 */

public class MovieRepository {

    private int id;
    private String name;
    private String posterUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
