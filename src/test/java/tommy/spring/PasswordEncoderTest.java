package tommy.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import tommy.spring.domain.Member;
import tommy.spring.domain.Role;
import tommy.spring.persistence.MemberRepository;

@SpringBootTest
@Commit
public class PasswordEncoderTest {
@Autowired
private MemberRepository memberRepo;
@Autowired
private PasswordEncoder encoder;
@Test
public void testInsert() {
Member member = new Member();
member.setId("test");
member.setPassword(encoder.encode("manager"));
member.setName("홍길동");
member.setRole(Role.ROLE_MANAGER);
member.setEnabled(true);
memberRepo.save(member);
}
}