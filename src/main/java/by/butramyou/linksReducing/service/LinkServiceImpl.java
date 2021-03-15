package by.butramyou.linksReducing.service;

import by.butramyou.linksReducing.repositories.LinkRepositories;
import by.butramyou.linksReducing.web.model.Link;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * @author D.Butramyou
 */
@Slf4j
@Service
public class LinkServiceImpl implements LinkService {

  private final LinkRepositories linkRepositories;

  public LinkServiceImpl(LinkRepositories linkRepositories) {
    this.linkRepositories = linkRepositories;
  }

  @Override
  public Link getLinkById(String id) throws ObjectNotFoundException {

    Optional<Link> link = linkRepositories.findById(id);
    if (link.isEmpty()) {
      log.info("Object with id: " + id + " didn't found");
      throw new ObjectNotFoundException("Object with id: " + id + " didn't found");
    }
    log.info("Found an object with id: " + id + " and originalLink: " + link.get().getOriginalLink());
    return link.get();
  }

  @Override
  public Link saveNewLink(String link) {
    Link newLink = Link.builder()
        .id(getUniqueId())
        .originalLink(link)
        .build();

    linkRepositories.save(newLink);
    log.info("Created an new object with id: " + newLink.getId());
    return newLink;
  }

  /**
   * Generating unique id
   * For id used first 8 signs from UUID
   *
   * @return unique id
   */
  private String getUniqueId() {
    String id;
    long start = new Date().getTime();

    do {
      id = UUID.randomUUID().toString().substring(0, 8);
    } while (linkRepositories.findById(id).isPresent());
    log.info("Found an unique id: " + id + " in " + (new Date().getTime() - start) + " milliseconds");

    return id;
  }
}
