package program.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="addresses")
@JsonIgnoreProperties({ "id" })
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "street", length = 200, nullable = false)
    private String street;
    @Column(name = "suite", length = 200, nullable = false)
    private String suite;
    @Column(name = "city", length = 200, nullable = false)
    private String city;
    @Column(name = "zipcode", length = 200, nullable = false)
    private String zipcode;
    @JsonManagedReference
    @Column(name = "geo", length = 200, nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_id", referencedColumnName = "id")
    private Geo geo;
    @OneToOne(mappedBy = "address")
    private User user;
}

