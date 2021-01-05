package com.greencross.test.test1;


import com.greencross.test.dto.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Test1Controller {
	private final Test1ServiceMock svc;
	public Test1Controller(Test1ServiceMock svc) {
		this.svc = svc;
	}
	@RequestMapping(value="/tasks",  method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> tasks() {
		return svc.tasks();
	}
}
