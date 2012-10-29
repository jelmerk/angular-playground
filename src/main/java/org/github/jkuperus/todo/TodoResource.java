package org.github.jkuperus.todo;

import com.sun.jersey.api.NotFoundException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * @author Jelmer Kuperus
 */
@Named
@Path("/todos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @Inject
    private TodoRepository todoRepository;

    @GET
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GET
    @Path("{id}")
    public Todo getTodo(@PathParam("id") long id) {
        Todo todo = todoRepository.findById(id);
        if (todo == null) {
            throw new NotFoundException();
        }
        return todo;
    }

    @PUT
    public void update(Todo todo) {

    }

    @POST
    public void save(Todo todo) {
        todoRepository.persist(todo);
    }

}
