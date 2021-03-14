package by.butramyou.linksReducing.web.controller;

import by.butramyou.linksReducing.service.LinkService;
import by.butramyou.linksReducing.web.model.Link;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author D.Butramyou
 */
@WebMvcTest(LinkController.class)
class LinkControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  LinkService linkService;

  @Test
  void getLinkById() throws Exception {
    Link validLink = Link.builder().id("223e6a83").originalLink("https://www.google.com/").build();
    given(linkService.getLinkById(any(String.class))).willReturn(validLink);

    mockMvc.perform(get("/api/v1/" + validLink.getId()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id", is(validLink.getId())))
        .andExpect(jsonPath("$.originalLink", is("https://www.google.com/")));
  }

  @Test
  void saveNewLink() throws Exception {
    mockMvc.perform(post("/api/v1/")
        .contentType(MediaType.APPLICATION_JSON)
        .param("url", "https://vk.com/"))
        .andExpect(status().isCreated());
  }
}