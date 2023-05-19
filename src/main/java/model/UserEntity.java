package model;

import jakarta.persistence.*;
import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "usershop")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @FormParam("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

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

    @FormParam("token")
    @Column(name = "token")
    @Getter
    @Setter
    private String token;

}
