package main.model;

import main.Controller.ToDoListServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListService implements ToDoListServiceimp {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public ToDoListService() {
        super();
    }

    @Override
    public List<ToDoList> getAllLists() {
        List<ToDoList> lists = new ArrayList<>();
        toDoListRepository.findAll().forEach(e -> lists.add(e));
        return lists;
    }

    @Override
    public ToDoList getToDoListById(int ListId) {
        ToDoList obj = toDoListRepository.findById(ListId).get();
        return obj;
    }

    @Override
    public boolean newToDoList(ToDoList toDoList) {
        toDoListRepository.save(toDoList);
        return true;
    }

    @Override
    public void deleteList(int ListId) {
        toDoListRepository.deleteById(ListId);

    }
}
