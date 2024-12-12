package repository.imp;

import model.Students;
import org.springframework.stereotype.Repository;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentRepositoryImp implements StudentRepository {
   @PersistenceContext
   private EntityManager em;

   @Override
   public List<Students> getStudents() {
      return em.createQuery("from Students", Students.class).getResultList();
   }

   @Override
   public Students getStudent(int id) {
      return em.find(Students.class, id);
   }

   @Override
   public boolean saveStudent(Students student) {
      try{
         if(student == null){
            em.persist(student);
         }else{
            em.merge(student);
         }
         return true;
      }catch(Exception e){
         return false;
      }

   }

   @Override
   public boolean deleteStudent(int id) {
      Students student = em.find(Students.class, id);
      if(student != null) {
         em.remove(student);
         return true;
      }
      return false;
   }
}
