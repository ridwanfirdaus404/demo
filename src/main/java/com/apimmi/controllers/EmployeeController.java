package com.apimmi.controllers;

import java.util.List;

import javax.validation.Valid;

import com.apimmi.dto.EmployeeDto;
import com.apimmi.dto.ListEmployeeResponse;
import com.apimmi.dto.ResponseData;
import com.apimmi.models.entities.Employee;
import com.apimmi.models.entities.Position;
import com.apimmi.services.EmployeeService;
import com.apimmi.services.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<ResponseData<Employee>> create(@Valid @RequestBody EmployeeDto employeeDto, Errors error) {
        ResponseData<Employee> responseData = new ResponseData<>();
        if (error.hasErrors()) {
            for (ObjectError error2 : error.getAllErrors()) {
                responseData.getMessage().add(error2.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        try {
            Position position = positionService.findById(employeeDto.getPosition_id());
            Employee employee = new Employee();
            employee.setName(employeeDto.getName());
            employee.setBirthDate(employeeDto.getBirthDate());
            employee.setGender(employeeDto.getGender());
            employee.setIdNumber(employeeDto.getIdNumber());
            employee.setPosition(position);

            responseData.setStatus(true);
            responseData.setPayload(employeeService.insert(employee));
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ListEmployeeResponse> findAll() {
        return employeeService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Employee findOne(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public ResponseEntity<ResponseData<Employee>> update(@Valid @RequestBody Employee employee, Errors error) {
        ResponseData<Employee> responseData = new ResponseData<>();
        if (error.hasErrors()) {
            for (ObjectError error2 : error.getAllErrors()) {
                responseData.getMessage().add(error2.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        try {
            responseData.setStatus(true);
            responseData.setPayload(employeeService.insert(employee));
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Employee>> getListForPagination(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Employee> list = employeeService.getListForPagination(pageNo, pageSize);

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
