package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

  @Autowired
    private PersonRepository personRepository;

  @Autowired
    private PhoneRepository phoneRepository;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("people", personRepository.findAll());
    return "index.html";
  }

  @GetMapping("/people/remove")
  public @ResponseBody
  Integer remove(@RequestParam Integer id)
  {
    personRepository.deleteById(id);
    return id;
  }

  @PostMapping("/people/add")
  public @ResponseBody
  Person add(@RequestBody Person person)
  {
    personRepository.findAll();
    personRepository.save(person);
    return person;
  }

  @GetMapping("/phone/{id}")
  public String phone(Model model, @PathVariable Integer id) throws Exception {
     Person person = personRepository.findById(id).get();

     if(person == null)
     {
       throw new Exception("Person is empty");
     }

     model.addAttribute(person);

     return "phone.html";
  }

  @GetMapping("/phone/remove")
  public @ResponseBody Integer removePhone(@RequestBody Integer id){

    phoneRepository.deleteById(id);
    return id;
  }

  @PostMapping("/phone/add")
  public @ResponseBody Phone addPhone(@RequestBody Phone phone){
    personRepository.findAll();

    return phoneRepository.save(phone);
  }

}
