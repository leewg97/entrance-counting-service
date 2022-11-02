package com.sb.entrancecounting.controller.error;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BaseErrorController.class)
class BaseErrorControllerTest {

    private final MockMvc mockMvc;

    public BaseErrorControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @DisplayName("[view][GET] 에러 페이지 - 페이지 없음")
    @Test
    void givenWrongURI_whenRequestingPage_thenReturns404ErrorPage() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/wrong-uri"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}