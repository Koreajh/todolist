package kr.or.connect.service;

import java.util.List;
import org.springframework.stereotype.Service;
import kr.or.connect.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;

@Service
public class TodoService {
	private TodoDao dao;
	
	public TodoService(TodoDao dao) {
		this.dao = dao;
	}
	
	public int clearCompleted() {
		return dao.clearCompleted();
	}
	
	public boolean deleteById(Integer id) {
		Integer old = dao.deleteById(id);
		return old != null;
	}
	
	public int count() {
		return dao.count();
	}
	
	public Todo create(Todo todo) {
		Integer id = dao.insert(todo);
		todo.setId(id);
		return todo;
	}
	
	public List<Todo> showTodoAll() {
		return dao.showTodoAll();
	}
	
	public List<Todo> showTodoActive() {
		return dao.showTodoActive();
	}
	
	public List<Todo> showTodoCompleted() {
		return dao.showTodoCompleted();
	}
	
	public boolean updateComplete(Integer id) {
		Integer old = dao.updateComplete(id);
		return old != null;
	}
	
	

}
