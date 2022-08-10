package tommy.spring.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tommy.spring.domain.Member;
import tommy.spring.domain.SecurityUser;
import tommy.spring.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {
@Autowired
private MemberRepository memberRepo;
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//// MemberRepository로 회원정보를 조회하여 UserDetails 타입의 객체로 리턴한다.
//	return null;
//}
Optional<Member> optional = memberRepo.findById(username);
if(!optional.isPresent()) {
throw new UsernameNotFoundException(username + " 사용자 없음");
}else {
Member member = optional.get();
return new SecurityUser(member);
}
}
}
