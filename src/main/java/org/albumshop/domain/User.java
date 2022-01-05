package org.albumshop.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="user", uniqueConstraints = {
		@UniqueConstraint(
				columnNames = {"nickName", "email", "phone"}
		)
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String nickName;
	@NotNull
	private String pass;
	private String address;
	private String email;
	@NotNull
	private String phone;
	private String photo;
	@NotNull
	private String grade;
	@NotNull
	private Integer score;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate birth;
	private String gender;
	@OneToMany(mappedBy = "user")
	private List<MyList> mylists;
	

	@Enumerated(EnumType.STRING)
	org.albumshop.security.UserRole urole;
	
	
	
	
}
