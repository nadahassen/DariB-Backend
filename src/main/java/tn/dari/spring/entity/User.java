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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  @NonNull  private Long id;

	@Column(name="email")
	  @NonNull private String email;

	@Column(name="nom")
	  @NonNull private String nom;
	
	@Column(name="prenom")
	  @NonNull private String prenom;
	
	@Column(name="username")
	  @NonNull  private String username;
	
	@Column(name="tel")
	  @NonNull private String tel;
	

	@Column(name="password")
	  @NonNull private String password;
	
	@JsonIgnore 
	@OneToMany(cascade =CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
    private Set<favoris> favoris;
    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
    private Set<Notification> Notification;
	

}