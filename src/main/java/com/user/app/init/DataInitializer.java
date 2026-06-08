package com.user.app.init;

import com.user.app.entity.Department;
import com.user.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0) {
            Department hr = new Department("Human Resources", "HR");
            Department it = new Department("Information Technology", "IT");
            Department sales = new Department("Sales & Marketing", "SALES");
            Department finance = new Department("Finance", "FIN");
            
            departmentRepository.saveAll(Arrays.asList(hr, it, sales, finance));
            System.out.println(">>> Seeded default departments: HR, IT, SALES, FIN");
        }
    }
}
