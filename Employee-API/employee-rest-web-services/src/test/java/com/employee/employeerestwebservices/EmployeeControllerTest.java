package com.employee.employeerestwebservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EmployeeControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @MockBean
    private EmployeeRepository mockRepository;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init() {
        Employee employee = new Employee((long) 1,"firstname","lastname","Male","01/01/1995","dept");
        when(mockRepository.findAll()).thenReturn((List<Employee>) employee);
    }

    @Test
    void findAll() throws Exception {
        List<Employee> employee = Arrays.asList(
                new Employee((long) 1,"xyz","lastname","Male","01/01/1995","dept"),
                new Employee((long) 2,"abc","lastname2","Female","01/01/1996","dept2"));
        when(mockRepository.findAll()).thenReturn(employee.stream()
                .sorted((e1,e2)-> e1.getFirstName().compareTo(e2.getFirstName()))
                .collect(Collectors.toList()));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].firstName", is("abc")))
                .andExpect(jsonPath("$[0].lastName", is("lastname2")))
                .andExpect(jsonPath("$[1].id", is(1)))
                .andExpect(jsonPath("$[1].firstName", is("xyz")))
                .andExpect(jsonPath("$[1].lastName", is("lastname")))
                .andExpect(jsonPath("$[1].gender", is("Male")));

        verify(mockRepository, times(1)).findAll();

    }

    @Test
    void newBook() throws Exception {
        Employee employee = new Employee((long) 1,"firstname","lastname","Male","01/01/1995","dept");
        when(mockRepository.save(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/employees")
                .content(om.writeValueAsString(employee))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                /*.andDo(print())*/
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("firstname")))
                .andExpect(jsonPath("$.lastName", is("lastname")))
                .andExpect(jsonPath("$.gender", is("Male")));

        verify(mockRepository, times(1)).save(any(Employee.class));
    }

}