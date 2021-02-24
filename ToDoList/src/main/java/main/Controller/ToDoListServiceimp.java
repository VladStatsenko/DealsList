package main.Controller;

import main.model.ToDoList;

import java.util.List;

public interface ToDoListServiceimp {
    List<ToDoList> getAllLists();
    ToDoList getToDoListById(int ListId);
    boolean newToDoList (ToDoList toDoList);
    void deleteList (int ListId);

}
