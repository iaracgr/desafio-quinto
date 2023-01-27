package com.gonzalez.desafioquinto.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class UserEntity implements UserDetails { //

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id")
    private   String userId;

    @Column(name = "first_name",nullable = false)
     private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private List<RoleEntity> roles;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column (name = "description")
    private String description;

    @Column(name = "soft_delete",nullable = false)
    private boolean softDelete=false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    public boolean isEnabled() { return !softDelete; }

}
