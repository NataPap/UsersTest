package program.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="companies")
@JsonIgnoreProperties({ "id" })
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 200, nullable = false)
    private String name;
    @Column(name = "catchPhrase", length = 200, nullable = false)
    private String catchPhrase;
    @Column(name = "bs", length = 200, nullable = false)
    private String bs;
    @OneToOne(mappedBy = "company")
    private User user;
}
