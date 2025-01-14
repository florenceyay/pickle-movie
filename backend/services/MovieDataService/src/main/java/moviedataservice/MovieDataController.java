package moviedataservice;

import moviedataservice.MovieDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieDataController {

    private static final Logger logger = LoggerFactory.getLogger(MovieDataController.class);

    private final MovieDataService movieService;

    @Autowired
    public MovieDataController(MovieDataService movieService) {
        this.movieService = movieService;
    }

    /**
     * Unified search endpoint.
     * Searches for movies in Elasticsearch and falls back to TMDb if no results are found.
     *
     * @param title The movie title to search for.
     * @return List of movies matching the title.
     */
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        logger.info("Received search request for title: {}", title);

        // Step 1: Search in Elasticsearch
        List<Movie> movies = movieService.searchMoviesFromRepository(title);

        // Step 2: If not found, perform real-time fallback
        if (movies.isEmpty()) {
            logger.warn("No movies found for title: {} in Elasticsearch. Initiating real-time fetch.", title);
            try {
                movies = movieService.searchMovie(title); // Fetch specific movie by title
                logger.info("Real-time fetch completed. Found {} movies for title: {}", movies.size(), title);
            } catch (Exception e) {
                logger.error("Error during real-time fetch for title {}: {}", title, e.getMessage(), e);
                throw new RuntimeException("Error during real-time fetch: " + e.getMessage());
            }
        } else {
            logger.info("Found {} movies for title: {}", movies.size(), title);
        }

        return movies;
    }

    /**
     * Health check endpoint to verify service availability.
     *
     * @return Health check message.
     */
    @GetMapping("/health")
    public String healthCheck() {
        logger.info("Health check endpoint accessed.");
        return "Movie Service is up and running!";
    }
}
