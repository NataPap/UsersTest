package program.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="geos")
@JsonIgnoreProperties({ "id" })
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lat", length = 200, nullable = false)
    private String lat;
    @Column(name = "lnd", length = 200, nullable = false)
    private String lng;
    @OneToOne(mappedBy = "geo")
    private Address address;
}
