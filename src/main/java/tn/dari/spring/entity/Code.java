package tn.dari.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_code")
public class Code {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
//	@Lob
	@Column(name = "code")
	private String code;

	@OneToOne(mappedBy = "code")
	private User user;

	public Code(String code) {
		super();
		this.code = code;
	}

	@Override
	public String toString() {
		return "Code [id=" + id + ", code=" + code + ", user=" + user + "]";
	}
	
	

}