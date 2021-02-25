package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;
import java.util.Optional;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private UserInputService userinputService;
    private StudentDao studentDao;

    @Autowired
    public void setUserInputService(UserInputService userinputService) {
        this.userinputService = userinputService;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Type student name: ");
        String newName = userinputService.getString();


        Student newStudent = new Student();
        newStudent.setName(newName);

        return save(newStudent);
    }

    @Override
    public Student save(Student student) {

        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student removeStudent = find(id);
        if(removeStudent == null) throw new IllegalArgumentException("The Student with id"+id+"can not be found");
        studentDao.delete(id);
        return removeStudent;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null.");
        Student original = find(student.getId());
        if(original.getId() > 0){
            System.out.println("The student is"+student+".");
            System.out.println("Type the new name of student: ");
            String newName = userinputService.getString();
            Student editedStudent = original;
            editedStudent.setName(newName);

            return editedStudent;
        }

        return null;
    }
}
