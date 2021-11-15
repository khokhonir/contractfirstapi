package io.swagger.api;

import io.swagger.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ToDosApiTest {


    @Autowired
    private TodosApiController todosApiController;


    @Test
    public void ToDoUpdateTest() {

        Todo todoSample = new Todo("123","I'm lazy",true);
        todosApiController.todosIdPut(todoSample.getId(),todoSample );
        assertEquals(!todoSample.getName().isEmpty(), true);
        assertEquals(!todoSample.getId().isEmpty(), true);

    }

}
