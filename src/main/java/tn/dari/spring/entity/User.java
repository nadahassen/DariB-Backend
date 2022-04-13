package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="user")
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="email")
	private String email;

	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="username")
	private String username;
	
	@Column(name="tel")
	private String tel;
	

	@Column(name="password")
	private String password;
	

     
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="User")
    @JsonIgnore
    private Set<likeAnnonce> likes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="User")
    @JsonIgnore
    private Set<CommentAnnonce> comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="User")
    @JsonIgnore
    private Set<SignalerAnnonce> signaux;
    

	@ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
	
	
	
	@Override
	public String getUsername() {
		return this.username;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
