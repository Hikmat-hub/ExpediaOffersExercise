package com.expedia.exercise.validator;

import com.expedia.exercise.config.Application;
import com.expedia.exercise.controller.OfferController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class MinMaxDateValidatorTest {

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new OfferController()).build();
    }

    @Test
    public void testFailedPresentFutureDate()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/filter")
                .accept(MediaType.TEXT_HTML)
                .param("maxTripStartDate", "09/22/2050")
                .param("minTripStartDate", "10/22/2050"))
                .andExpect(MockMvcResultMatchers.model().errorCount(1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
