package persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BuddyInfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBuddy() throws Exception {
        this.mockMvc.perform(post("/newAB")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\"")));
        this.mockMvc.perform(post("/addBuddy?abId=1&firstName=TestF&lastName=TestL&phoneNumber=123456&address=TestAddress")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("TestF")));
        this.mockMvc.perform(get("/getBuddy?abId=1&buddyId=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("TestF")));
        this.mockMvc.perform(delete("/deleteBuddy?abId=1&buddyId=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("TestF")));
    }

}