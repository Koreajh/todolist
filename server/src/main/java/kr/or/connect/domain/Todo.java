package kr.or.connect.domain;

public class Todo {
	private Integer id;
	private String todo;
	private Integer completed;
	private String time;
	
	public Todo() {
	}
	
	public Todo(String todo) {
		this.todo=todo;
	}
	
	public Todo(Integer id,String todo,Integer completed,String time) {
		this.id=id;
		this.todo=todo;
		this.completed=completed;
		this.time=time;
	}
	
	
	public Integer getCompleted() {
		return completed;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	
}
