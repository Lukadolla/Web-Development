package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/helloQS")
    public @ResponseBody String helloQueryString(@RequestParam String name, @RequestParam(name="age") int myAge) {
        if (myAge > 30) {
            return "Hello " + name + ", you old fart!";
        }

        return "Hello " + name + ", ain't life good!";
    }

    @GetMapping("/helloPV/{age}")
    public @ResponseBody String helloPathVariable(@PathVariable int age) {
        if (age > 30) {
            return "Hello, you old fart!";
        }

        return "Hello, ain't life good!";
    }
    
    @GetMapping("/helloCombined/{age}")
    public @ResponseBody String helloCombined(@RequestParam String name, @PathVariable int age) {
        if (age > 30) {
            return "Hello " + name + ", you old fart!";
        }

        return "Hello " + name + ", ain't life good!";
    }

    @PostMapping("/raw")
    public @ResponseBody String rawPost(@RequestBody String name) {
        return name;
    }

    @PostMapping("/helloRaw")
    public @ResponseBody String helloRaw(@RequestBody String data) {
        return data;
    }

    @PostMapping("/helloObj")
    public @ResponseBody String helloObj(PersonalData data) {
        if (data.getAge() > 30) {
            return "Hello " + data.getName() + ", you old fart!";
        }

        return "Hello " + data.getName() + ", ain't life good!";
    }

}

