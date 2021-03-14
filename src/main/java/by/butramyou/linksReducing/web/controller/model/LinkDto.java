package by.butramyou.linksReducing.web.controller.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LinkDto {

  @Id
  private String id;
  private String originalLink;
}
