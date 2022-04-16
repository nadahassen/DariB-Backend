package tn.dari.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@RequiredArgsConstructor 
@ToString
public class DemandeVisite implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull private Long idVisite;
	
	Boolean status ;
	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern="dd-M-yyyy hh:mm:ss") 
	Date DateVisite;
	String Cin;
	String Garant;
	

	@ManyToOne
	User user;
	@ManyToOne
	Property property ;
	//@OneToOne(cascade = CascadeType.ALL)
	//private Image image;
	
}
