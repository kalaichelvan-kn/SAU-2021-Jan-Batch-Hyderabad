package com.accolite.restapi_au.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PrivateMessage> privateMessageset;

    public User(){}
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PrivateMessage> getPrivateMessageset() {
        return privateMessageset;
    }

    public void setPrivateMessageset(Set<PrivateMessage> privateMessageset) {
        this.privateMessageset = privateMessageset;
    }
}
