package com.greencross.test.test1;

import com.greencross.test.dto.Task;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Test1ServiceMock {
	private final static List<Task> TASKS = List.of(
			Task.builder().id(1).name("Task1").dateRequest("2020-12-08").dateDue("2021-01-10").requester("User1").tags(new String[]{""}).description("%%%% 문서 정리")
				.tags(new String[]{"Documentation"}).build(),
			Task.builder().id(93940501L).name("Task2").dateRequest("2020-12-09").dateDue("2021-01-15").requester("User2").description("XXX가 YYYY 하는 버그 수정")
				.tags(new String[]{"Debug", "Test"}).build(),
			Task.builder().id(29000001L).name("Task3").dateRequest("2020-12-10").dateDue("2021-01-11").requester("User2").description("$##$ 기능 요청")
				.tags(new String[]{"Development", "Documentation"}).build(),
			Task.builder().id(10000001L).name("Task4").dateRequest("2020-12-11").dateDue("2021-01-12").requester("Manager1").description("$$$$ **** 기능 개발")
				.tags(new String[]{"Development"}).build(),
			Task.builder().id(10001001L).name("Task5").dateRequest("2020-12-11").dateDue("2021-01-19").requester("Manager2").description("$$$$$ 테스트")
				.tags(new String[]{"Test"}).build()
	);
	private final static Map<Long, Task> DATABASE = new HashMap<>();
	@PostConstruct
	protected void initializeDatabase() {
		TASKS.forEach(t->DATABASE.put(t.id(), t));
	}
	public Collection<Task> tasks() {
		return DATABASE.values();
	}
	public void delete(long id) throws TaskNotFoundException {
		if(!DATABASE.containsKey(id)) throw new TaskNotFoundException(id);
		DATABASE.remove(id);
	}
	public static class TaskNotFoundException extends Exception {
		public TaskNotFoundException(long taskId) {
			super("Can't find Task:" + taskId);
		}
	}
}
