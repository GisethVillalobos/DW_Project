package com.example.TransmiApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransmiApp.model.Assignment;
import com.example.TransmiApp.service.AssignmentService;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/all")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/read/{idAssignment}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long idAssignment) {
        Optional<Assignment> assignment = assignmentService.getAssignmentById(idAssignment);
        return assignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @PutMapping("/update/{idAssignment}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long idAssignment, @RequestBody Assignment assignment) {
        Optional<Assignment> updatedAssignment = assignmentService.updateAssignment(idAssignment, assignment);
        return updatedAssignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idAssignment}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long idAssignment) {
        assignmentService.deleteAssignment(idAssignment);
        return ResponseEntity.noContent().build();
    }
}
