package se331.rest.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String telNo;
    @ManyToMany
    List<Event> eventHistory;

}
