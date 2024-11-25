package com.start.db.repository.account;

import com.start.db.entity.account.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);

    List<Member> findAllByIdExists(String id);


}