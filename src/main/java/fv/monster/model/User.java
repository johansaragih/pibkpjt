package fv.monster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import lombok.Data;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"tickets"})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    private String firstname;
    private String lastname;
    private String phoneNumber;

    @ManyToMany
    private List<Role> roles;
    private boolean isActivated;
    private String activationHash;
}
