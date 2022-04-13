package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SignalerAnnonce implements Serializable{
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long IdSignaler ;
	@NonNull String Description ;
	@NonNull Date dateCreation ;
	@ManyToOne(cascade = CascadeType.ALL)
	Annonce Annonce;

}
