//package com.ci.controllertest;
//
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//
//import com.ci.entity.Employee;
//import com.ci.resource.EmployeeResource;
//import com.ci.service.EmployeeService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@WebMvcTest(value = EmployeeResource.class)
//public class EmployeeResourceTest {
//
//	@MockBean
//	private EmployeeService employeeService;
//
//	@Mock
//	MockMvc mockMvc;
//
//	@Test
//	public void testSaveEmployee() {
//		Employee employee = new Employee(1l, "Vaibhav", "vaibhav@gmail.com", "SDE", 95000l);
//		when(employeeService.saveEmployee(employee).thenReturn(employee);
//		ObjectMapper objectMapper = new ObjectMapper();
//		String employeeJSON = objectMapper.writeValueAsString(employee);
//		ResultActions perform = mockMvc
//				.perform(post("/employee/save").content(employeeJSON).contentType(MediaType.APPLICATION_JSON));
//		MvcResult mvcResult = perform.andReturn();
//		MockHttpServletResponse response = mvcResult.getResponse();
//		int status = response.getStatus();
//		assertNotEquals(201, status);
//	}
//}