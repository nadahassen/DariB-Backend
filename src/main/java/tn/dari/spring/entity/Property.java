package tn.dari.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import tn.dari.spring.entity.favoris;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @NonNull private Long idProprety;
	
	@Column (name="surface")
	  @NonNull private float surface;
	
	@Column (name="numroom")
	  @NonNull private float numroom;
	
	@Column (name="description")
	  @NonNull private String description;
	
	@Column(name="prix")
	  @NonNull private float prix;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Property")
	private Set<favoris> favoris;

    //private Set<favoris> favoris;
   // @OneToMany(cascade =CascadeType.ALL,mappedBy="Property",fetch=FetchType.LAZY)
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Property")
    private Set<Notification> Notification;
    
    
}


