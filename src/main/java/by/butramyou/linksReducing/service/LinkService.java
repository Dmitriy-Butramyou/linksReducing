package by.butramyou.linksReducing.service;

import by.butramyou.linksReducing.web.model.Link;
import javassist.tools.rmi.ObjectNotFoundException;

/**
 * @author D.Butramyou
 */
public interface LinkService {

  /**
   * Getting object by id
   *
   * @param id object id
   * @return object {@link Link}
   */
  Link getLinkById(String id) throws ObjectNotFoundException;

  /**
   * Creating new short link
   *
   * @param link link for reducing
   * @return saved object {@link Link}
   */
  Link saveNewLink(String link);

}
