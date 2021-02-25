package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentsConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentsConfig.class);

        StudentDao dao = context.getBean(StudentDao.class);
        UserInputService scanner = context.getBean(UserInputService.class);
        StudentManagement management = context.getBean(StudentManagement.class);
        Student newStudent = management.create();
        System.out.println();
        System.out.println(management.edit(newStudent));

        context.close();

        //Test save student
        //Student newStudent1 = dao.save(new Student("test"));
        //System.out.println("newStudent = " + newStudent1);

        //Student newStudent2 = dao.save(new Student("Mikael"));
        //Student newStudent3 = dao.save(new Student("Edward"));

        //System.out.println(dao.find(3)); //print out Edward

        //System.out.println(dao.findAll());

        //dao.delete(2);
        //System.out.println(dao.find(2));

        //System.out.println(scanner.getString());

    }
}
