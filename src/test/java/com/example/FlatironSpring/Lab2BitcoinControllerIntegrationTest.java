package com.example.FlatironSpring;

import com.example.FlatironSpring.controller.CryptoController;
import com.example.FlatironSpring.controller.Lab2BitcoinController;
import com.example.FlatironSpring.service.CryptoService;
import com.example.FlatironSpring.service.Lab2BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Lab2BitcoinController.class)
class Lab2BitcoinControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Lab2BitcoinService bitcoinService;


    @WithMockUser(username = "fakeUser")
    @Test
    void checkGetBitcoinInfo() throws Exception {
        mockMvc.perform(get("/bitcoinPrice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The current price of a Bitcoin is: ")));

    }
}