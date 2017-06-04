package kr.or.connect.todo.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import kr.or.connect.domain.Todo;

@Repository
public class TodoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class);
	
	public TodoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("todo")
				.usingGeneratedKeyColumns("id")
				.usingColumns("todo");
	}
	
	public Integer insert(Todo todo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public int count() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(TodoSqls.COUNT_TODO_NOTCOMPLETED, params, Integer.class);
	}
	
	public List<Todo> showTodoAll() {
		Map<String, Object> params = Collections.emptyMap();
		try {
			return jdbc.query(TodoSqls.SHOW_TODO_ALL, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Todo> showTodoActive() {
		Map<String, Object> params = Collections.emptyMap();
		try {
			return jdbc.query(TodoSqls.SHOW_TODO_ACTIVE, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Todo> showTodoCompleted() {
		Map<String, Object> params = Collections.emptyMap();
		try {
			return jdbc.query(TodoSqls.SHOW_TODO_COMPLETED, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(TodoSqls.DELETE_BY_ID, params);
	}
	
	public int updateComplete(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(TodoSqls.TODO_COMPLETE, params);
	}
	
	public int clearCompleted() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.update(TodoSqls.CLEAR_COMPLETED, params);
	}
	
	public Todo selectById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(TodoSqls.SELECT_BY_ID, params, rowMapper);
	}
	
	
	
}
