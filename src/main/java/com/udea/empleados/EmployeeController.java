/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.empleados;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("*")
@RequestMapping("/empleados")
@Api(value = "Employee Management System", description = "Operations pertaining to employee "
        + "in Employee Management System")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

   /*
    @RequestMapping("/")
    String home() {
        return "Bienvenidos a la UdeA ";
    }
    */
    

    @ApiOperation(value = "Add an employee")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee create(@ApiParam(value = "Employee object store in database table", required = true) 
    @RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Get an employee by Id")
    @RequestMapping(method = RequestMethod.GET, value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Employee> get(@ApiParam(value = "Employee id from which employee object will retrieve",
            required = true) @PathVariable String employeeId) {

        return employeeRepository.findById(employeeId);
    }

    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved list"),
    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> empleados() {
        return employeeRepository.findAll();
    }
}
