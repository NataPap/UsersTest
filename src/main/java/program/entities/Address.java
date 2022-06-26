package program.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="addresses")
public class Address {
    @Id
    private int id;
    @Column(name = "street", length = 200, nullable = false)
    private String street;
    @Column(name = "suite", length = 200, nullable = false)
    private String suite;
    @Column(name = "city", length = 200, nullable = false)
    private String city;
    @Column(name = "zipcode", length = 200, nullable = false)
    private String zipcode;

    @OneToOne
    @JoinColumn(name = "geo_id", referencedColumnName = "id")
    private Geo geo;

    @OneToOne(mappedBy = "address")
    private User user;
}

