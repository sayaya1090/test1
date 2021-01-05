package com.greencross.test.test1;

import com.greencross.test.dto.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test1ServiceMock {
	private final static List<Task> tasks = List.of(
			Task.builder().id(00000001L).name("Task1").dateRequest("2020-12-08").dateDue("2021-01-10").requester("User1").tags(new String[]{""}).description("%%%% 문서 정리")
				.tags(new String[]{"Documentation"}).build(),
			Task.builder().id(00010001L).name("Task2").dateRequest("2020-12-09").dateDue("2021-01-15").requester("User2").description("XXX가 YYYY 하는 버그 수정")
				.tags(new String[]{"Debug", "Test"}).build(),
			Task.builder().id(01000001L).name("Task3").dateRequest("2020-12-10").dateDue("2021-01-11").requester("User2").description("$##$ 기능 요청")
				.tags(new String[]{"Development", "Documentation"}).build(),
			Task.builder().id(10000001L).name("Task4").dateRequest("2020-12-11").dateDue("2021-01-12").requester("Manager1").description("$$$$ **** 기능 개발")
				.tags(new String[]{"Development"}).build(),
			Task.builder().id(10001001L).name("Task5").dateRequest("2020-12-11").dateDue("2021-01-19").requester("Manager2").description("$$$$$ 테스트")
				.tags(new String[]{"Test"}).build()
	);
	public List<Task> tasks() {
		return tasks;
	}
	public static class TaskNotFoundException extends RuntimeException {
		public TaskNotFoundException(long proband) {
			super("Can't find Proband:" + proband);
		}
		public TaskNotFoundException(long proband, String editor) {
			super("Can't find Proband:" + proband + ", " + editor);
		}
	}
}
