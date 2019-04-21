package com.nowcoder.project;

import com.nowcoder.project.controllers.BookRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testRestIndex() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/bookRest/index")
                        ).andReturn().getResponse().getContentAsString();
        System.out.println(result);


    }
}
