package ch.bbw.personenverwaltung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class MainController {
    private final PersonRepository personRepository;

    @Autowired
    public MainController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Index
    // Overview
    @GetMapping({"/", "/all"})
    public String getAll(Model model) {
        model.addAttribute("persons", personRepository.findAll());

        return "/all";
    }

    // Create, Save
    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("person", new Person());

        return "create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute Person person, Model model) {
        personRepository.save(person);

        return "create";
    }

    /*
    @PostMapping("/create")
    public String postCreate(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create";
        }
        personRepository.save(person);
        return "redirect:/all";
    }
    */

    /*
    @PostMapping("/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam String firstname
            , @RequestParam String lastname, @RequestParam String email, @RequestParam String gender, @RequestParam LocalDate birthdate) {

        Person p = new Person(firstname, lastname, birthdate, email, gender);
        personRepository.save(p);
        return "Saved";
    }*/

    // Edit
    @GetMapping("/edit/{id}")
    public String getEdit(@PathVariable long id, Model model) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            model.addAttribute("person", person);
            return "edit";
        }
        return "404";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable long id) {

        this.personRepository.deleteById(id);
        return "redirect:/all";
    }

    /*
    @GetMapping("/bySearch")
    public String getBySearch(Model model) {
        model.addAttribute("persons", personRepository.findByLastname());

        return "all";
    }*/
}
