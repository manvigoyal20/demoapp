// package com.example.springboot.controller;

// //import java.time.LocalDateTime;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class SpringController {

// 	private transient Integer val = 0;
	
// 	@GetMapping(value = "/")
// 	public String getValue() {

// //		LocalDateTime date = LocalDateTime.now();
// //
// //		Integer year = date.getYear();
// //		Integer month = date.getMonthValue();
// //		Integer day = date.getDayOfMonth();
// //		Integer hour = date.getHour();
// //		Integer min = date.getMinute();
// //		Integer sec = date.getSecond();
// 		val++;
// //		Integer count = year + month + day + hour + min + sec + 1;
// 		String result = "Mr. DevOps" + val;
// 		return result;
// 	}
// }

package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Employee;

@RestController
public class SpringController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}

}
