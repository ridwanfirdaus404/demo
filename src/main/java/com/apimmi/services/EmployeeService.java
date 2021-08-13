package com.apimmi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apimmi.dto.ListEmployeeResponse;
import com.apimmi.models.entities.Employee;
import com.apimmi.models.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee insert(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee getById(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if (!emp.isPresent()) {
            return null;
        }
        return emp.get();
    }

    public List<Employee> findAll() {
        return employeeRepo.findAllEmp();
    }

    public List<ListEmployeeResponse> getAll() {
        List<Employee> emp = (List<Employee>) employeeRepo.findAllEmp();

        List<ListEmployeeResponse> employeeResponses = new ArrayList<>();

        for (int i = 0; i < emp.size(); i++) {
            ListEmployeeResponse le = new ListEmployeeResponse();
            le.setBirthDate(emp.get(i).getBirthDate());
            le.setGender(emp.get(i).getGender());
            le.setId(emp.get(i).getId());
            le.setIdNumber(emp.get(i).getIdNumber());
            le.setName(emp.get(i).getName());
            le.setNamePosition(emp.get(i).getPosition().getName());
            le.setPositionId(emp.get(i).getPosition().getId());

            employeeResponses.add(le);
        }

        return employeeResponses;
    }

    public void delete(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        emp.get().setIsDelete(1);

        employeeRepo.save(emp.get());
    }

    public List<Employee> getListForPagination(Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        org.springframework.data.domain.Page<Employee> pagedResult = employeeRepo.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }

}
