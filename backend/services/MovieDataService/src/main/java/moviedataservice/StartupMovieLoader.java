package moviedataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupMovieLoader {

    private final MovieDataService movieService;
    private static final Logger logger = LoggerFactory.getLogger(StartupMovieLoader.class);

    public StartupMovieLoader(MovieDataService movieDataService) {
        this.movieService = movieDataService;
    }

    /**
     * Trigger fetching and indexing of popular movies when the application starts.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void loadPopularMovies() {
        logger.info("Application started: Fetching and indexing popular movies...");
        try {
            movieService.initializeMovies();
            logger.info("Initial popular movies fetched and indexed successfully!");
        } catch (Exception e) {
            logger.error("Error during startup movie loading: " + e.getMessage());
        }
    }
}

