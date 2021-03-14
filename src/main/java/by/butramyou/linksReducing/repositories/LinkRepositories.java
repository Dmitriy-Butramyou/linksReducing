package by.butramyou.linksReducing.repositories;

import by.butramyou.linksReducing.web.controller.model.LinkDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepositories extends JpaRepository<LinkDto, String> {
}
