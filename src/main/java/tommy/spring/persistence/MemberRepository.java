package tommy.spring.persistence;

import org.springframework.data.repository.CrudRepository;

import tommy.spring.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
}
