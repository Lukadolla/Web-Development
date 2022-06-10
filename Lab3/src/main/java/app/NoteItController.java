package app;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Date;

@Controller
public class NoteItController {

    private HashMap<Integer, Note> notes = new HashMap<Integer, Note>();
    private int count;

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/create")
    public String create(){
        return "create.html";
    }

    @GetMapping("/browse")
    public String browse(Model model){
        model.addAttribute("notes", notes);
        return "browse.html";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable("id") int id){
        Note note = notes.get(id);

        if(note == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }

        model.addAttribute("note", note);
        return "view.html";
    }

    @PostMapping("/create")
    public void createNote(HttpServletResponse httpServletResponse, String noteBox, String title){
        Note note = new Note();
        note.setTitle(title);
        note.setNote(noteBox);
        note.setId(count);
        Date date = new Date();
        note.setDateCreated(date);
        note.setDateEdited(date);

        notes.put(count, note);
        count++;

        try{
            httpServletResponse.sendRedirect("/browse");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}



