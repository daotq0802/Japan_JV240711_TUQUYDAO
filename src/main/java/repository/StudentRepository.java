package repository;

import model.Students;

import java.util.List;

public interface StudentRepository {
   List<Students> getStudents();
   Students getStudent(int id);
   boolean saveStudent(Students student);
   boolean deleteStudent(int id);
}
