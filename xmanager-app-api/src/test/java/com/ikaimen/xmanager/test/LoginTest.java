package com.ikaimen.xmanager.test;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * Created by Tom Chen on 2017/7/20.
 */
public class LoginTest extends BaseTest {
    @Test
    public void index() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/app/login").param("username","admin").param("password","test")
                .accept(MediaType.TEXT_HTML))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
