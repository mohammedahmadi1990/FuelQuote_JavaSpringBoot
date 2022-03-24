package com.petrol.fuelquote.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @Column(name="full_name", length = 50)
    private String fullName;

    @Column(nullable = true, length = 100)
    private String address01;

    @Column(nullable = true, length = 100)
    private String address02;

    @Column(nullable = true, length = 50)
    private String city;

    @Column(nullable = true, length = 2)
    private String state;

    @Column(nullable = true, length = 9)
    private String zipcode;

    @OneToMany(mappedBy="user")
    private Set<Quote> quotes;

    public User(String username, String password, Collection<Role> roles, String fullName, String address01, String address02, String city, String state, String zipcode, Set<Quote> quotes) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.fullName = fullName;
        this.address01 = address01;
        this.address02 = address02;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.quotes = quotes;
    }
}
