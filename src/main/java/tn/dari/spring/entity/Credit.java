package tn.dari.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.dari.spring.entity.Banque;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Table(name = "Credit")
public class Credit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCredit;
	
	@Column(name="montant")
	@NonNull private float montant;
	
	
	 @Column(name="salaire") 
	 @NonNull float salaire;
	 
	
	@Column(name="partmensuel")
	@NonNull private double partmensuel;
	/*
	 * @Column(name="interet")
	 * 
	 * @NonNull private double interet;
	 */
	
	@Column(name="duree")
	@NonNull private int duree;
	
	
	@ManyToOne
	@JsonIgnore
    @JsonBackReference 
	private Banque banque;

	
	/*
	 * @ManyToOne private User user;
	 * 
	 * 
	 */
	
	


}
