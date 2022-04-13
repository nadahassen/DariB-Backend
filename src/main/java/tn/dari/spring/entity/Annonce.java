package tn.dari.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


//annonce

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Table(name="Annonce")
public class Annonce implements Serializable  {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long IdAnnonce ;
	@Column(name="Surface")
	@NonNull Float Surface ;
	@Column(name="Description")
	@NonNull String Description ;
	@Column(name="Location")
	@NonNull String Location ;
	@Column(name="price")
	@NonNull Float price ;
	@Column(name="Parking")
	@NonNull Boolean Parking ;
	@Column(name="RoomsNum")
	@NonNull Integer RoomsNum ;
	@Column(name="image")
	@NonNull String image ;
	
     private TypeBiensEnum TypeProp  ;
     private OfferTypeEnum OfferType ;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy="Annonce")
     private Set<CommentAnnonce> Comments;
  
     @OneToMany(cascade = CascadeType.ALL, mappedBy="Annonce")
     private Set<SearchAnnonce> Searchs;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy="Annonce")
     private Set<SignalerAnnonce> Signaux;
     
    
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy="Annonce")
     private Set<likeAnnonce> likes;
    
    
     @ManyToOne(cascade = CascadeType.ALL)
 	User User;
}
