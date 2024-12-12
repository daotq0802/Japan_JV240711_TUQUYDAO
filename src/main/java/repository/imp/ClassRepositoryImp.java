package repository.imp;

import model.Classes;
import org.springframework.stereotype.Repository;
import repository.ClassRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class ClassRepositoryImp implements ClassRepository {
   @PersistenceContext
   private EntityManager em;

   @Override
   public List<Classes> getClasses() {
      return em.createQuery("select c from Classes c", Classes.class).getResultList();
   }

   @Override
   public Classes getClass(int id) {
      return em.find(Classes.class, id);
   }

   @Override
   public boolean saveClass(Classes classes) {
      try{
         if(classes == null){
            em.persist(classes);
         }else{
            em.merge(classes);
         }
         return true;
      }catch(Exception e){
         e.printStackTrace();
         return false;
      }
   }

   @Override
   public boolean deleteClass(int id) {
      Classes classes = em.find(Classes.class, id);
      if(classes != null){
         em.remove(classes);
         return true;
      }
      return false;
   }
}
