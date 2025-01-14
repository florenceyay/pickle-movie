package moviedataservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchMovies() throws Exception {
        mockMvc.perform(get("/movies/search")
                        .param("title", "little mermaid"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].title").value("Little Mermaid"));
    }

    @Test
    public void testHealthCheck() throws Exception {
        mockMvc.perform(get("/movies/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Movie Service is up and running!"));
    }
}
