package service.imp;

import model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ClassRepository;
import service.ClassService;

import java.util.List;

@Service
public class ClassServiceImp implements ClassService {
   @Autowired
   private ClassRepository classRepository;

   @Override
   public List<Classes> getClasses() {
      return classRepository.getClasses();
   }

   @Override
   public Classes getClass(int id) {
      return classRepository.getClass(id);
   }

   @Override
   @Transactional
   public boolean saveClass(Classes classes) {
      List<Classes> classesList = classRepository.getClasses();
      if (classesList.stream().anyMatch(c -> c.getName().equalsIgnoreCase(classes.getName()))) {
         throw new IllegalArgumentException("Lớp đã tồn tại!");
      }
     return classRepository.saveClass(classes);
   }

   @Override
   @Transactional
   public boolean deleteClass(Classes classes) {
     return classRepository.deleteClass(classes.getId());
   }
}
