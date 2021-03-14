package by.butramyou.linksReducing.web.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author D.Butramyou
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Link {

  @Id
  private String id;
  private String originalLink;
}
