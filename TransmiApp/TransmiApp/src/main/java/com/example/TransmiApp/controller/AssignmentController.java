package com.example.TransmiApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransmiApp.model.Assignment;
import com.example.TransmiApp.service.AssignmentService;

@RestController
@RequestMapping("/api/assignment")
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Assignment> findAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/read/{idAssignment}")
    @ResponseStatus(value = HttpStatus.OK)
    public Assignment findById(@PathVariable Long idAssignment) {
        return assignmentService.getAssignmentById(idAssignment);
    }

    @PutMapping("/update/{idAssignment}")
    @ResponseStatus(value = HttpStatus.OK)
    public Assignment updateAssignment(@PathVariable Long idAssignment, @RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(idAssignment, assignment);
    }

    @DeleteMapping("/delete/{idAssignment}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAssignment(@PathVariable Long idAssignment) {
        assignmentService.deleteAssignment(idAssignment);
    }

}
