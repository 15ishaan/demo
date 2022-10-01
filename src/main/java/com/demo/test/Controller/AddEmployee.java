package com.demo.test.Controller;

import com.demo.test.model.Employee;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddEmployee {

    MongoTemplate mongoTemplate;

    @PostMapping("/addEmployee")
    private Employee add(@RequestBody Employee employee)
    {
        mongoTemplate.save(employee);
        return employee;
    }
}
