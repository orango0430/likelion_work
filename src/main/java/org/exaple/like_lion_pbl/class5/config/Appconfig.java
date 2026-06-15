package org.exaple.like_lion_pbl.class5.config;
import org.exaple.like_lion_pbl.class5.package2.MemberRepository;
import org.exaple.like_lion_pbl.class5.package2.MemberService;
import org.exaple.like_lion_pbl.class5.package2.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Bean
    public MemberRepository memberRepository (){
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService (){
        return new MemberService(memberRepository());
    }
}
