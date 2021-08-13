package com.apimmi.models.repos;

import java.util.List;

import com.apimmi.models.entities.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.isDelete = 0")
    public List<Employee> findAllEmp();

}
