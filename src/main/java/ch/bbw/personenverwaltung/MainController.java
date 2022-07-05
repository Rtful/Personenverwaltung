package ch.bbw.personenverwaltung;

import com.sun.xml.bind.v2.TODO;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    private final PersonRepository personRepository;

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
        List<Person> persons = personRepository.findByLastname("Holenstein");
        System.out.println(persons);
//        model.addAttribute("person", new Person("Peter", "Muster", LocalDate.of(1870, 3, 21), "peter.muster@icloud.com", "m"));
        model.addAttribute(new Person());
        return "create";
    }

    @PostMapping("/create")
    public String mySubmitMethod(@ModelAttribute Person person) {
        System.out.println("helloWorld");
        System.out.println(person.getFirstname());
        System.out.println(person.getLastname());
        System.out.println(person.getBirthdate());
        personRepository.save(person);
        return "create";
    }

    // The way to pass parameters via get is to use ?param=value
    // In this case it would be url?id=
    @GetMapping(path = "/edit")
    public String editPerson(@RequestParam Long id, Model model) {
        // TODO create a form for displaying the personData (do not allow changing of the id) Make sure to use calendar field for dates
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            model.addAttribute(person);
            return "edit";
        }
        return "404";
    }

    @GetMapping(path = "/all")
    public @ResponseBody String getAllPersons(Model model) {
        // TODO create a nice table for displaying all these people (tip: use th:each)
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute(people);
        return "all";
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String firstname
            , @RequestParam String lastname, @RequestParam String email, @RequestParam String gender, @RequestParam LocalDate birthdate) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        // TODO Create form that sends to this page ("/add") with POST parameters that fit the names in the signature above

        Person p = new Person(firstname, lastname, birthdate, email, gender);
        personRepository.save(p);
        return "Saved";
    }

}
