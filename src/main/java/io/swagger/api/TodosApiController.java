package io.swagger.api;

import io.swagger.model.InlineResponse500;
import io.swagger.model.Todo;
import io.swagger.model.Todos;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-15T07:28:28.659Z[GMT]")
@RestController
public class TodosApiController implements TodosApi {

    private static final Logger log = LoggerFactory.getLogger(TodosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

     Todo todo = new Todo();


    @org.springframework.beans.factory.annotation.Autowired
    public TodosApiController(ObjectMapper objectMapper, HttpServletRequest request ) {
        this.objectMapper = objectMapper;
        this.request = request;

    }


    public ResponseEntity<Todos> todosGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                log.debug("Returning a default to do action");
                return new ResponseEntity<Todos>(objectMapper.readValue("{\n  \"todos\" : [ {\n    \"name\" : \"Do some work\",\n    \"id\" : \"abc123\",\n    \"completed\" : true\n  }, {\n    \"name\" : \"Do some work\",\n    \"id\" : \"abc123\",\n    \"completed\" : true\n  } ]\n}", Todos.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Todos>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Todos>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> todosIdDelete() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Todo> todosIdPut(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") String id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Todo body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                    log.debug("Updating a Todo action");
                   // Todo todo = new Todo();
                    todo.setId(id);
                    todo.setName(body.getName());
                    if (body.isCompleted()) {
                        todo.setCompleted(true);
                    }
                    else{
                        todo.setCompleted(false);
                    }

                    return new ResponseEntity<Todo>(todo, HttpStatus.OK);

               // return new ResponseEntity<Todo>(objectMapper.readValue("{\n  \"name\" : \"Do some work\",\n  \"id\" : \"abc123\",\n  \"completed\" : true\n}", Todo.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Todo>(HttpStatus.NOT_IMPLEMENTED);
    }



    public ResponseEntity<Todo> todosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Todo body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                log.debug("Adding a Todo action");

                System.out.print (" The name is *****************" +  body.getName());
                System.out.print (" The id is *****************" +  body.getId());

                todo.setId(body.getId());
                todo.setName(body.getName());
                if (body.isCompleted()) {
                    todo.setCompleted(true);
                }
                else{
                    todo.setCompleted(false);
                }

                if (body.getName().equals("I'm lazy")){
                    log.error("Returning I'm lazy");
                    return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
                }else {
                    return new ResponseEntity<Todo>(todo, HttpStatus.OK);
                   // return new ResponseEntity<Todo>(objectMapper.readValue("{\n  \"name\" : \"Do some work\",\n  \"id\" : \"abc123\",\n  \"completed\" : true\n}", Todo.class), HttpStatus.NOT_IMPLEMENTED);
                }
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Todo>(HttpStatus.NOT_IMPLEMENTED);
    }

}
