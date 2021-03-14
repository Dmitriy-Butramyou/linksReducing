package by.butramyou.linksReducing.web.controller;

import by.butramyou.linksReducing.web.controller.model.LinkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class LinkController {

  @GetMapping("/{linkId}")
  public ResponseEntity<LinkDto> getLinkById(@PathVariable String linkId) {
    //todo impl
    return new ResponseEntity<>(LinkDto.builder().originalLink("/test.ru").id("TestID").build(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<LinkDto> saveNewLink(@RequestBody LinkDto linkDto) {
    //todo impl
    return new ResponseEntity(HttpStatus.CREATED);
  }

}
