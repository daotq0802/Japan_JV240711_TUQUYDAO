package service.imp;

import model.Classes;
import model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {
   @Autowired
   private StudentRepository studentRepository;

   @Override
   public List<Students> getStudents() {
      return studentRepository.getStudents();
   }

   @Override
   public Students getStudentById(int id) {
      return studentRepository.getStudent(id);
   }

   @Override
   @Transactional
   public boolean saveStudent(Students student) {
      List<Students> studentList = studentRepository.getStudents();
      if (studentList.stream().anyMatch(c -> c.getName().equalsIgnoreCase(student.getName()))) {
         throw new IllegalArgumentException("Lớp đã tồn tại!");
      }
      return studentRepository.saveStudent(student);
   }

   @Override
   @Transactional
   public boolean deleteStudent(Students student) {
      return studentRepository.deleteStudent(student.getId());
   }
}
