package employee.service;

import employee.exception.ResourceNotFoundException;
import employee.model.Employee;
import employee.repository.EmployeeRepository;
import junit.framework.TestCase;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest extends TestCase {

    @Mock
    public EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

    public EmployeeService employeeService = new EmployeeService(employeeRepository);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {

        //Given
        when(employeeRepository.findAll())
                .thenReturn(getEmployees());

        //When
        List<Employee> allEmployees = employeeService.findAll();

        //Then
        Assert.assertEquals(2, allEmployees.size());
    }


    @Test
    public void testFindById() throws ResourceNotFoundException {

        //Given
        when(employeeRepository.findById(anyLong()))
                .thenReturn(Optional.of(getEmployee()));

        //When
        Employee employee = employeeService.findById(anyLong());

        //Then
        Assert.assertEquals(1, employee.getId());
        Assert.assertEquals("Amir", employee.getFirstName());
    }


    @Test
    public void testSave() {
        //Given
        when(employeeRepository.findById(anyLong()))
                .thenReturn(Optional.of(getEmployee()));
        when(employeeRepository.save(any()))
                .thenReturn(getEmployee());

        //When
        Employee employee = employeeService.save(any());

        //Then
        Assert.assertEquals(1, employee.getId());
        Assert.assertEquals("MENJLI", employee.getLastName());
    }

    @NotNull
    private List<Employee> getEmployees() {
        Employee firstEmployee = new Employee();
        Employee secondEmployee = new Employee();

        firstEmployee.setEmailId("amir.menjli@gmail.com");
        firstEmployee.setFirstName("Amir");
        firstEmployee.setLastName("MENJLI");
        firstEmployee.setId(1);

        secondEmployee.setEmailId("jean.paul@gmail.com");
        secondEmployee.setFirstName("Jean");
        secondEmployee.setLastName("PAUL");
        secondEmployee.setId(2);

        return Arrays.asList(firstEmployee, secondEmployee);
    }

    @NotNull
    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmailId("amir.menjli@gmail.com");
        employee.setFirstName("Amir");
        employee.setLastName("MENJLI");
        employee.setId(1);
        return employee;
    }
}
