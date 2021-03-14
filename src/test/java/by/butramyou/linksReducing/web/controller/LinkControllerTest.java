package by.butramyou.linksReducing.web.controller;

import by.butramyou.linksReducing.web.controller.model.LinkDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LinkController.class)
class LinkControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void getLinkById() throws Exception {
    mockMvc.perform(get("/api/v1/id1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
  }

  @Test
  void saveNewLink() throws Exception {
    LinkDto linkDto = LinkDto.builder().build();
    String linkDtoJson = objectMapper.writeValueAsString(linkDto);

    mockMvc.perform(post("/api/v1/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(linkDtoJson))
        .andExpect(status().isCreated());
  }

}