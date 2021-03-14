package by.butramyou.linksReducing.repositories;

import by.butramyou.linksReducing.web.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author D.Butramyou
 */
public interface LinkRepositories extends JpaRepository<Link, String> {
}
