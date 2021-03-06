package com.ci.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.ci.entity.Employee;
import com.ci.resource.EmployeeResource;
import com.ci.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = EmployeeResource.class)
public class ControllerTest {

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {
		Employee employee = new Employee(1l, "Vaibhav", "vaibhav@gmail.com", "SDE", 95000l);
		when(employeeService.saveEmployee(employee)).thenReturn(employee);

		ObjectMapper mapper = new ObjectMapper();
		String employeeJSON = mapper.writeValueAsString(employee);

		ResultActions perform = mockMvc
				.perform(post("/employee/save").content(employeeJSON).contentType(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int actual = response.getStatus();
		assertEquals(201, actual);

	}

}
