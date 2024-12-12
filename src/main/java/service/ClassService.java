package service;

import model.Classes;

import java.util.List;

public interface ClassService {
   List<Classes> getClasses();
   Classes getClass(int id);
   boolean saveClass(Classes classes);
   boolean deleteClass(Classes classes);
}
