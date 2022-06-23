package program.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {
    @JsonUnwrapped
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name", length = 200, nullable = false)
    private String name;
    @Column(name="username", length = 200, nullable = false)
    private String username;
    @Column(name="email", length = 200, nullable = false)
    private String email;
    @JsonManagedReference
    @OneToOne
    @PrimaryKeyJoinColumn
    private Address address;

    @Column(name="phone", length = 200, nullable = false)
    private String phone;
    @Column(name="website", length = 200, nullable = false)
    private String website;
    @JsonManagedReference
    @OneToOne
    @PrimaryKeyJoinColumn
    private Company company;
}
