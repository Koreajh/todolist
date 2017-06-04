package kr.or.connect.todo.persistence;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.domain.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoDaoTest {
	
	
	
	@Autowired
	private TodoDao dao;
	
	@Test
	public void showTodoAll() {
		List<Todo> allTodos = dao.showTodoAll();
		assertThat(allTodos, is(notNullValue()));
	}


	@Test
	public void insert() {
		// given
		Todo todo = new Todo(1,"궁금이",0,"2017-06-02");

		// when
		Integer id = dao.insert(todo);

		// then
		Todo selected = dao.selectById(id);
		System.out.println(selected);
		assertThat(selected.getTodo(), is("궁금이"));
	}
	
	@Test
	public void count() {
		int count = dao.count();
		System.out.println(count);
	}
	
	@Test
	public void showTodoActive() {
		List<Todo> todoActives = dao.showTodoActive();
		assertThat(todoActives, is(notNullValue()));
	}
	
	@Test
	public void showTodoCompleted() {
		List<Todo> todoCompleteds = dao.showTodoCompleted();
		assertThat(todoCompleteds, is(notNullValue()));
	}
	
	
	@Test
	public void deleteById() {
		// given
		Todo todo = new Todo("네이버 자바");
		Integer id = dao.insert(todo);

		// when
		int affected = dao.deleteById(id);

		// Then
		assertThat(affected, is(1));
	}
	
	@Test
	public void updateComplete() {
		// Given
		Todo todo = new Todo("네이버 C");
		Integer id = dao.insert(todo);

		// When
		todo.setId(id);
		int affected = dao.updateComplete(id);

		// Then
		assertThat(affected, is(1));
		Todo updated = dao.selectById(id);
		assertThat(updated.getCompleted(), is(1));
	}
	
}
