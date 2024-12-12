package service;

import model.Students;

import java.util.List;

public interface StudentService {
   List<Students> getStudents();
   Students getStudentById(int id);
   boolean saveStudent(Students student);
   boolean deleteStudent(Students student);
}
