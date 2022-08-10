package tommy.spring.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;

	public SecurityUser(Member member) {
//		super(member.getId(), "{noop}" + member.getPassword(),
//				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		super(member.getId(), member.getPassword(),
		AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}