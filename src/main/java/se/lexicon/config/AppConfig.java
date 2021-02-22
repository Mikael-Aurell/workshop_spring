package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;

//using java
@Configuration
public class AppConfig {
    @Bean("StudentDao")
    public StudentDao studentDao(){
        return new StudentDaoImpl();
    }
}
