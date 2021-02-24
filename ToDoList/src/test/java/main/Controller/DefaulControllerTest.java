package main.Controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class DefaulControllerTest extends AbstractIntegrationTest {
    @Test
    public void shouldReturnSomething() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")) // request_mapping_path это наш URL по которому доступен REST API
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
