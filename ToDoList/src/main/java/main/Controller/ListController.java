package main.Controller;

import main.model.ToDoList;
import main.model.ToDoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController {

    private final ToDoListService toDoListService;

    public ListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping("/lists/")
    public List<ToDoList> list() {
        List<ToDoList> toDoLists = toDoListService.getAllLists();
        return toDoLists;
    }

    @PostMapping("/lists/")
    public boolean add(ToDoList toDoList) {
        boolean flag = toDoListService.newToDoList(toDoList);
        return flag;
    }

    @GetMapping("/lists{id}")
    public void get(@PathVariable int id) {
        ToDoList toDoList = toDoListService.getToDoListById(id);
    }

    @DeleteMapping("/lists{id}")
    public void delete(@PathVariable int id) {
        toDoListService.deleteList(id);
    }
}

