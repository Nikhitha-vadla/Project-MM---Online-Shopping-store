package com.massmutual.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String userName;

    @Column
    @JsonIgnore
    @ToString.Exclude
    private String password;

    private LocalDateTime created;

    private String name;

    private String email;

    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    private String status="active";

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="addressID")
    private Address address;

//    public boolean doesUserHasRole(String s) {
//        return roles.stream()
//                .filter(role -> {
//                    return role.getName().equalsIgnoreCase(s);
//                })
//                .findFirst()
//                .isPresent();
//    }

}
