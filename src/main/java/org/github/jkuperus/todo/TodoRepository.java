package org.github.jkuperus.todo;

import java.util.List;

/**
 * @author Jelmer Kuperus
 */
public interface TodoRepository {

    List<Todo> findAll();

    Todo findById(long id);

    void persist(Todo todo);
}
