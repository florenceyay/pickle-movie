package moviedataservice;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {
    // Custom query to find movies by title
    List<Movie> findByTitle(String title);
}