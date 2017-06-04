package kr.or.connect.todo.api;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.or.connect.domain.Todo;
import kr.or.connect.service.TodoService;

@RestController
@RequestMapping(value = "/api/todos", method = {RequestMethod.GET, RequestMethod.POST})
public class TodoController {
	private final TodoService service;
	
	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	Todo insertTodo(@RequestBody Todo todo) {
		return service.create(todo);
	}
	
	@GetMapping("/count")
	int count() {
		return service.count();
	}
	
	@GetMapping("/showTodoAll")
	Collection<Todo> showTodoAll() {
		return service.showTodoAll();
	}
	
	@GetMapping("/showTodoActive")
	Collection<Todo> showTodoActive() {
		return service.showTodoActive();
	}
	
	@GetMapping("/showTodoCompleted")
	Collection<Todo> showTodoCompleted() {
		return service.showTodoCompleted();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	boolean deleteById(@PathVariable Integer id) {
		return service.deleteById(id);
	}
	
	@DeleteMapping("/clearCompleted")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	int clearCompleted() {
		 return service.clearCompleted();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void updateComplete(@PathVariable Integer id) {
		service.updateComplete(id);
	}
	
}
