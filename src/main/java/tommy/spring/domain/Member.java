package tommy.spring.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MYMEMBER")
public class Member {
	@Id
	private String id;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
}
