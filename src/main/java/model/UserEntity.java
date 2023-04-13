package model;

import jakarta.persistence.*;
import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @FormParam("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @FormParam("login")
    @Column(name = "login")
    @Getter
    @Setter
    private String login;

    @FormParam("password")
    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @FormParam("role")
    @Column(name = "role")
    @Getter
    @Setter
    private String role;
}
