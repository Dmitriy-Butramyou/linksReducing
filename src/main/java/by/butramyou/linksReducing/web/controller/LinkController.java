package by.butramyou.linksReducing.web.controller;

import by.butramyou.linksReducing.service.LinkService;
import by.butramyou.linksReducing.web.model.Link;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author D.Butramyou
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class LinkController {

  private final LinkService linkService;

  public LinkController(LinkService linkService) {
    this.linkService = linkService;
  }

  /**
   * Getting object {@link Link}
   * If link not found returning status {@link HttpStatus#NO_CONTENT}
   *
   * @param linkId id for link
   * @return object {@link Link} with status {@link HttpStatus#OK}
   */
  @GetMapping("/{linkId}")
  public ResponseEntity<Link> getLinkById(@PathVariable String linkId) {
    try {
      Link link = linkService.getLinkById(linkId);
      return new ResponseEntity<>(link, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Saving new short link
   * If url isn't valid returning status {@link HttpStatus#BAD_REQUEST}
   *
   * @param url link for reducing
   * @return object {@link Link} with status {@link HttpStatus#CREATED}
   */
  @PostMapping
  public ResponseEntity<Link> saveNewLink(String url) {
    UrlValidator urlValidator = new UrlValidator();
    if (urlValidator.isValid(url)) {
      Link newLink = linkService.saveNewLink(url);
      return new ResponseEntity<Link>(newLink, HttpStatus.CREATED);
    } else {
      log.error("Url isn't valid: " + url);
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }
}
