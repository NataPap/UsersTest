package program.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    private int id;
    @Column(name="name", length = 200, nullable = false)
    private String name;
    @Column(name="username", length = 200, nullable = false)
    private String username;
    @Email(regexp=".+@.+\\..+",message="Please provide a valid email address")
    @Column(name="email", length = 200, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name="phone", length = 200, nullable = false)
    private String phone;
    @Column(name="website", length = 200, nullable = false)
    private String website;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
}
