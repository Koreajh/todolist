package kr.or.connect.todo.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import kr.or.connect.TodoApplication;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TodoApplication.class)
@WebAppConfiguration
public class TodoControllerTest {
	
	@Before
	public void setUp() {
		this.mvc = webAppContextSetup(this.wac)
			.alwaysDo(print(System.out))
			.build();
	}
	
	@Autowired
	WebApplicationContext wac;
	MockMvc mvc;

	

	@Test
	public void showTodoAll() throws Exception {
		mvc.perform(
				get("/api/books/showTodoAll")
				);
	}
	
	@Test
	public void count() throws Exception {
		mvc.perform(
				get("/api/books/count")
				);
	}
	
	@Test
	public void showTodoActive() throws Exception {
		mvc.perform(
				get("/api/books/showTodoActive")
				);
	}
	
	@Test
	public void showTodoCompleted() throws Exception {
		mvc.perform(
				get("/api/books/showTodoCompleted")
				);
	}
	
	@Test
	public void deleteById() throws Exception {
		mvc.perform(
				delete("/api/books/364")
					.contentType(MediaType.APPLICATION_JSON)
			);
	}
	
	
	@Test
	public void clearCompleted() throws Exception {
		mvc.perform(
				delete("/api/books/clearCompleted")
			);
	}
	
	@Test
	public void updateComplete() throws Exception {
		mvc.perform(
				put("/api/books/366")
					.contentType(MediaType.APPLICATION_JSON)
				);
	}
}
