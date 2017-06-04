package kr.or.connect.todo.persistence;

public class TodoSqls {
	static final String DELETE_BY_ID =
			"DELETE FROM todo WHERE id= :id";
	static final String CLEAR_COMPLETED =
			"DELETE FROM todo WHERE completed='1'";
	static final String INSERT_TODO =
			"INSERT INTO todo VALUES(todo= :todo)";
	static final String SHOW_TODO_ALL =
			"SELECT id,todo,completed FROM todo ORDER BY date DESC";
	static final String SHOW_TODO_ACTIVE =
			"SELECT todo FROM todo WHERE completed='0' ORDER BY date DESC";
	static final String SHOW_TODO_COMPLETED =
			"SELECT todo FROM todo WHERE completed='1' ORDER BY date DESC";
	static final String COUNT_TODO_NOTCOMPLETED =
			"SELECT count(*) FROM todo WHERE completed='0'";
	static final String TODO_COMPLETE =
			"UPDATE todo SET completed='1' WHERE id= :id";
	static final String SELECT_BY_ID =
			"SELECT id,todo,completed,date FROM todo WHERE id = :id";	
	
}
