package de.ait;

import de.ait.app.HibernateConf;
import de.ait.models.User;
import de.ait.repositories.impl.UsersRepositoryImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConf.class);
    UsersRepositoryImpl repository = context.getBean(UsersRepositoryImpl.class);
        User user = User.builder()
                .email("annaTEST@gmail.com")
                .password("qwerty0072")
                .build();

        System.out.println(user);

       repository.save(user);




    }
}