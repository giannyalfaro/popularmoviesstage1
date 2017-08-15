package movie.popular.stage.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s3081865 on 14/08/2017.
 */

public class Movie {

    @SerializedName("id")
    public int id;

    @SerializedName("original_title")
    public String name;

    @SerializedName("poster_path")
    public String posterUrl;

    @SerializedName("overview")
    public String plotSynopsis;

    @SerializedName("vote_average")
    public double averageRating;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("backdrop_path")
    public String backdropUrl;

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

    public String getPlotSynopsis() {
        return plotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        this.backdropUrl = backdropUrl;
    }
}
