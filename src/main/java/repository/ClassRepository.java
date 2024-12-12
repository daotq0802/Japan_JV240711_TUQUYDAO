package repository;

import model.Classes;

import java.util.List;

public interface ClassRepository {
   List<Classes> getClasses();
   Classes getClass(int id);
   boolean saveClass(Classes classes);
   boolean deleteClass(int id);
}
