package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;
import se.lexicon.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao dao = context.getBean("studentDao", StudentDao.class);

        //Test save student
        Student newStudent1 = dao.save(new Student("test"));
        //System.out.println("newStudent = " + newStudent1);

        Student newStudent2 = dao.save(new Student("Mikael"));
        Student newStudent3 = dao.save(new Student("Edward"));

        System.out.println(dao.find(3)); //print out Edward

        System.out.println(dao.findAll());

        dao.delete(2);
        System.out.println(dao.find(2));


    }
}
