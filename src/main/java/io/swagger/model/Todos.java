package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Todo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Todos
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-15T07:28:28.659Z[GMT]")


public class Todos   {
  @JsonProperty("todos")
  @Valid
  private List<Todo> todos = new ArrayList<Todo>();

  public Todos todos(List<Todo> todos) {
    this.todos = todos;
    return this;
  }

  public Todos addTodosItem(Todo todosItem) {
    this.todos.add(todosItem);
    return this;
  }

  /**
   * Get todos
   * @return todos
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Todo> getTodos() {
    return todos;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Todos todos = (Todos) o;
    return Objects.equals(this.todos, todos.todos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(todos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Todos {\n");
    
    sb.append("    todos: ").append(toIndentedString(todos)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
