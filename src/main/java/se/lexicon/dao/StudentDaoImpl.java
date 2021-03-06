package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.sequencer.StudentSequencer;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;



@Component
public class StudentDaoImpl implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student.getId() == 0){
            student.setId(StudentSequencer.nextStudentId());
        }
        students.add(student);

        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0){
            throw new IllegalArgumentException("Id should note be null");
        }
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }



    @Override
    public List<Student> findAll() {
        if (students == null) System.out.println("The list of student is empty.");
        return students;

    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
