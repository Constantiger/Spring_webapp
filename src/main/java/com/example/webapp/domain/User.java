package com.example.webapp.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;



@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table (name = "usr")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private boolean active;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public void setActive(boolean b) {
        this.active = b;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return this.username;
    }
}
