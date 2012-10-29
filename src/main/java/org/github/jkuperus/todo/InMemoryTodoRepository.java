package org.github.jkuperus.todo;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.*;

/**
 * @author Jelmer Kuperus
 */
@Named
@Singleton
public class InMemoryTodoRepository implements TodoRepository {

    private long counter = 1;

    private Map<Long, Todo> todos = new HashMap<Long, Todo>();

    public InMemoryTodoRepository() {
        todos.put(counter++, new Todo("item 1", false));
        todos.put(counter++, new Todo("item 2", false));
    }

    @Override
    public List<Todo> findAll() {
        return Collections.unmodifiableList(new ArrayList<Todo>(todos.values()));
    }

    @Override
    public Todo findById(long id) {
        return todos.get(id);
    }

    @Override
    public void persist(Todo todo) {
        todos.put(counter++, todo);
    }
}
