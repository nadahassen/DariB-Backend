package tn.dari.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "user")
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "tel")
	private String tel;

	@Column(name = "joinedAt")

	private LocalDateTime joinedAt;
	
	@Column(name = "password")
	private String password;
	
	@Column(nullable = false, length = 64)
	private String address;

	@Column(name="accountNonLocked",nullable = true, columnDefinition="boolean default true")
	private boolean accountNonLocked;
//	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}


	public User(String nom, String prenom, String username, String email, String tel, LocalDateTime joinedAt,
			String password, String address, boolean accountNonLocked, Collection<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.joinedAt = joinedAt;
		this.password = password;
		this.address = address;
		this.accountNonLocked = accountNonLocked;
		this.roles = roles;
	}


	public User(String nom, String prenom, String username, String email, String tel, String password, String address,
			Collection<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.address = address;
		this.roles = roles;
	}
	

}
