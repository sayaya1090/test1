package com.greencross.test.test1;


import com.greencross.test.dto.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
public class Test1Controller {
	private final Test1ServiceMock svc;
	public Test1Controller(Test1ServiceMock svc) {
		this.svc = svc;
	}
	@RequestMapping(value="/tasks",  method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Collection<Task> tasks() {
		return svc.tasks();
	}
	@RequestMapping(value="/tasks/{id}",  method= RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") long id) throws Test1ServiceMock.TaskNotFoundException {
		svc.delete(id);
	}
	@ExceptionHandler(Test1ServiceMock.TaskNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String taskNotFoundException(Test1ServiceMock.TaskNotFoundException e) {
		return e.getMessage();
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exceptionAll(Exception e) {
		return e.getMessage();
	}
}
