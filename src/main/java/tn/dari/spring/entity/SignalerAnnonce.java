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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;



@Entity
public class SignalerAnnonce implements Serializable{
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long idSignaler ;
	private String description ;
	private Date dateCreation ;
	@ManyToOne
	@JsonIgnore
	Annonce annonce;
	@Transient    
	private Long idAnnonce ;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	@Transient    
	private Long idUser;
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public Long getIdSignaler() {
		return idSignaler;
	}
	public void setIdSignaler(Long idSignaler) {
		this.idSignaler = idSignaler;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		annonce = annonce;
	}
	public Long getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	@Override
	public String toString() {
		return "SignalerAnnonce [idSignaler=" + idSignaler + ", description=" + description + ", dateCreation="
				+ dateCreation + ", Annonce=" + annonce + ", idAnnonce=" + idAnnonce + "]";
	}
	public SignalerAnnonce(Long idSignaler, String description, Date dateCreation, Annonce annonce,
			Long idAnnonce) {
		
		this.idSignaler = idSignaler;
		this.description = description;
		this.dateCreation = dateCreation;
		annonce = annonce;
		this.idAnnonce = idAnnonce;
	}
	
}
