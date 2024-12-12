package controller;

import model.Classes;
import model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.ClassService;
import service.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
   @Autowired
   private StudentService studentService;
   @Autowired
   private ClassService classService;

   @GetMapping("allStudents")
   public String allStudents(Model model) {
      model.addAttribute("students", studentService.getStudents());
      return "Students/allStudents";
   }

   @GetMapping("/initStudent")
   public String initStudent(Model model) {
      model.addAttribute("students", new Students());
      model.addAttribute("classes", classService.getClasses());
      return "Students/initStudent";
   }

   @PostMapping("/createStudent")
   public String createStudent(@Valid @ModelAttribute("students") Students students, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         return "/Students/initStudent";
      }
      try {
         studentService.saveStudent(students);
         return "redirect:/students/allStudents";
      } catch (IllegalArgumentException e) {
         model.addAttribute("errorMsg", e.getMessage());
         return "redirect:/students/initStudent";
      }
   }

   @GetMapping("/deleteStudent")
   public String deleteStudent(@RequestParam("id") int id, Model model) {
      studentService.deleteStudent(studentService.getStudentById(id));
      return "redirect:/students/allStudents";
   }

   @GetMapping("/initUpdate")
   public String initUpdate(@RequestParam("id") int id, Model model) {
      Students student = studentService.getStudentById(id);
      model.addAttribute("student", student);
      return "/Students/initUpdate";
   }

   @GetMapping("/updateStudent")
   public String updateStudent(@Valid @ModelAttribute("student") Students students, Model model) {
      boolean result = studentService.saveStudent(students);
      if(result) {
         return "redirect:/students/allStudents";
      }else{
         return "redirect:/students/initUpdate";
      }
   }
}
