package org.exaple.like_lion_pbl.class5;

import org.exaple.like_lion_pbl.class5.config.Appconfig;
import org.exaple.like_lion_pbl.class5.package2.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LikeLionPblApplication {
    public static void main(String[] args) {
        SpringApplication.run(LikeLionPblApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService service = context.getBean(MemberService.class);
        System.out.println("서비스 가져오기 성공" + service);

    }
}