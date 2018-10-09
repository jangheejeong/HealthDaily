package com.jang.healthdaily.repository;


import com.jang.healthdaily.model.Role.Role;
import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})


@Data
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String userName;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    @Column(name="email")
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @NotBlank
    @Size(max = 11)
    private String cell;

    @NotBlank
    @Size(max = 11)
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String userName, String email, String password,
                String cell, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.cell = cell;
        this.phone = phone;
    }
}