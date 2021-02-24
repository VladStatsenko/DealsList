package main;

import main.model.ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    private static AtomicInteger currentId = new AtomicInteger(1);
    private static ConcurrentHashMap<Integer, ToDoList> lists = new ConcurrentHashMap<Integer, ToDoList>();

    public static List<ToDoList> getAllLists() {
        ArrayList<ToDoList> dealArrayList = new ArrayList<ToDoList>();
        dealArrayList.addAll(lists.values());
        return dealArrayList;
    }

    public static int addDeal(ToDoList toDoList) {
        int id = currentId.incrementAndGet();
        toDoList.setId(id);
        lists.put(id, toDoList);
        return id;
    }

    public static ToDoList getToDoList(int listId) {
        if (lists.containsKey(listId)) {
            return lists.get(listId);
        }
        return null;
    }
    public static void deleteDeal(ToDoList toDoList){
        int id = toDoList.getId();
        if (lists.containsKey(id)) {
            lists.remove(id);
        }
    }
}
