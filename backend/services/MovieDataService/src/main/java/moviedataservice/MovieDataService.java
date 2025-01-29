package moviedataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieDataService {
    @Autowired
    private MovieRepository movieRepository;

    @Value("${tmdb.api.key}")
    private  String TMDB_API_KEY;

    private static final String POPULAR_MOVIE_SEARCH_PREFIX = "https://api.themoviedb.org/3/movie/popular?api_key=";
    private static final String MOVIE_SEARCH_PREFIX = "https://api.themoviedb.org/3/search/movie?api_key=";


    /*
    uses /movie/popular to fetch a large batch of movies.
     */
    public void initializeMovies() {
        for (int page=1; page<=10; page++) {
            String url = POPULAR_MOVIE_SEARCH_PREFIX + TMDB_API_KEY
                    + "&language=en-US&page=" + page;

            // Fetch data from TMDb
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

            if (results == null || results.size() == 0) continue;

            // Save movies to Elasticsearch
            movieRepository.saveAll(fetchMovies(results));
        }
    }

    public List<Movie> searchMovie(String title){
        List<Movie> movies = searchMoviesFromRepository(title);

        if(movies.isEmpty()){
            String url = MOVIE_SEARCH_PREFIX + TMDB_API_KEY + "&query=" + title;
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

            // Save to Elasticsearch
            movieRepository.saveAll(fetchMovies(results));
            movies = searchMoviesFromRepository(title);
        }
        return movies;
    }

    // Search movies by title
    public List<Movie> searchMoviesFromRepository(String title) {
        return movieRepository.findByTitle(title);
    }

    private String[] getGenreNames(List<Integer> genreIds) {
        if (genreIds == null) return new String[]{};
        return genreIds.stream().map(Genre::getNameById).toArray(String[]::new);

    }

    private int parseReleaseDate(String releaseDate) {
        if (releaseDate == null || releaseDate.isEmpty()) return 0;
        return Integer.parseInt(releaseDate.split("-")[0]); // Extract year
    }

    private List<Movie> fetchMovies(List<Map<String, Object>> results) {
        List<Movie> movies = results.stream().map(result -> {
            Movie movie = new Movie();
            movie.setId(result.get("id").toString());
            movie.setTitle((String) result.get("title"));
            movie.setGenre(getGenreNames((List<Integer>) result.get("genre_ids")));
            movie.setReleaseYear(parseReleaseDate((String) result.get("release_date")));
            movie.setOverview((String) result.get("overview"));
            movie.setRating(Double.parseDouble(result.get("vote_average").toString()));
            return movie;
        }).collect(Collectors.toList());

        return movies;
    }


}
