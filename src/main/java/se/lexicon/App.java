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
        System.out.println("#### App Configurations");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentsConfig.class);
        StudentDao dao = context.getBean(StudentDao.class);
        //UserInputService scanner = context.getBean(UserInputService.class);
        StudentManagement management = context.getBean(StudentManagement.class);
        System.out.println("--------------------------------------------------\n");

        System.out.println("### Save Student Test");
        Student test = management.save(new Student(1,"test"));
        System.out.println(dao.findAll());
        System.out.println("--------------------------------------------------\n");

        System.out.println("### Delete Student Test");
        management.remove(test.getId());
        System.out.println(management.findAll());
        System.out.println("--------------------------------------------------\n");

        System.out.println("### Create Students");
        Student student1 = management.create();
        Student student2 = management.create();
        Student student3 = management.create();
        Student student4 = management.create();
        System.out.println("--------------------------------------------------\n");

        System.out.println("### Find Student with id");
        Student theStudent = management.find(4);
        System.out.println("theStudent is= " + theStudent+".");
        System.out.println("--------------------------------------------------\n");

        System.out.println("### Get list of Students");
        System.out.println(management.findAll());
        System.out.println("--------------------------------------------------\n");

        System.out.println("### Edit student");
        Student editedStudent = management.edit(student3);
        System.out.println("editedStudent = " + editedStudent);
        System.out.println("--------------------------------------------------\n");

        context.close();
    }
}
