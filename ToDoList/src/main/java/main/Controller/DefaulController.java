package main.Controller;

import main.model.ToDoList;
import main.model.ToDoListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DefaulController {

    private final ToDoListService toDoListService;

    public DefaulController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @RequestMapping("/")
    public String index(Model model) {

        List<ToDoList> toDoLists = toDoListService.getAllLists();

        model.addAttribute("lists", toDoLists);
        model.addAttribute("listsCount", toDoLists.size());
        return "index";
    }
}
