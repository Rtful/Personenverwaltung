package ch.bbw.personenverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class MainController {
    private PersonRepository personRepository;

    @Autowired
    public MainController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/index")
    public String viewIndex() {

        return "index";
    }

    @GetMapping("/create")
    public String myViewDisplay(Model model) {
        model.addAttribute("person", new Person("Aaron", "Holenstein", LocalDate.of(2002, 7, 12), "aaron.holenstein@icloud.com", "m"));

        return "create";
    }

    @PostMapping("/create")
    public String mySubmitMethod(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        System.out.println(person.getFirstname());

        return "create";
    }
}
