package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;

//using java
@Configuration
public class StudentConfig {
    @Bean("studentDao")
    public StudentDao studentDao(){
        return new StudentDaoImpl();
    }
}
