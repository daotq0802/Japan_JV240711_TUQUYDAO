package controller;

import model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.ClassService;

import javax.validation.Valid;

@Controller
@RequestMapping("/classes")
public class ClassController {
   @Autowired
   private ClassService classService;

   @GetMapping("/allClasses")
   public String allClasses(Model model) {
      model.addAttribute("classes", classService.getClasses());
      return "/Classes/allClasses";
   }

   @GetMapping("/initClass")
   public String initClass(Model model) {
      model.addAttribute("classes", new Classes());
      return "/Classes/initClass";
   }

   @PostMapping("/createClass")
   public String createClass(@Valid @ModelAttribute("classes") Classes classes, Model model, BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
         return "/Classes/initClass";
      }
      try {
         classService.saveClass(classes);
         return "redirect:/classes/allClasses";
      } catch (IllegalArgumentException e) {
         model.addAttribute("errorMsg", e.getMessage());
         return "redirect:/classes/initClass";
      }

   }

   @GetMapping("/deleteClass")
   public String deleteClass(@RequestParam("id") int id, Model model) {
      classService.deleteClass(classService.getClass(id));
      return "redirect:/classes/allClasses";
   }

   @GetMapping("/initUpdate")
   public String initUpdate(@RequestParam("id") int id, Model model) {
      Classes classes = classService.getClass(id);
      model.addAttribute("classes", classes);
      return "/Classes/initUpdate";
   }

   @PostMapping("/updateClass")
   public String updateClass(@Valid @ModelAttribute("class") Classes classes, BindingResult bindingResult, Model model) {
      boolean result = classService.saveClass(classes);
      if(result) {
         return "redirect:/classes/allClasses";
      }else{
         return "redirect:/classes/initUpdate";
      }
   }
}