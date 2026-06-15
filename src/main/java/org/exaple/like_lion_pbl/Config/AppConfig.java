package org.exaple.like_lion_pbl.Config;

import org.exaple.like_lion_pbl.class5.package2.MemberRepository;
import org.exaple.like_lion_pbl.class5.package2.MemberService;
import org.exaple.like_lion_pbl.class5.package2.MemoryMemberRepository;
import org.exaple.like_lion_pbl.class5.role.role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository () {
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService () {
        return new MemberService(memberRepository());
    }

}
