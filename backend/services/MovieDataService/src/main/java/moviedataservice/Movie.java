package moviedataservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Arrays;

@Document(indexName = "movies")
public class Movie {

    @Id
    private String id; // Unique movie ID (e.g., from TMDb)

    private String title;
    private String[] genre;
    private int releaseYear;
    private String overview;
    private double rating;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String[] getGenre() { return genre; }
    public void setGenre(String[] genre) { this.genre = genre; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + Arrays.toString(genre) +
                ", releaseYear=" + releaseYear +
                ", overview='" + overview + '\'' +
                ", rating=" + rating +
                '}';
    }
}
