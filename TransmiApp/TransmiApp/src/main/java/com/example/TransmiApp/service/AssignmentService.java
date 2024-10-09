package com.example.TransmiApp.service;

import java.util.List;
import java.util.Optional;

import com.example.TransmiApp.model.Assignment;

public interface AssignmentService {
    List<Assignment> getAllAssignments();
    Optional<Assignment> getAssignmentById(Long idAssignment);
    Assignment createAssignment(Assignment assignment);
    Optional<Assignment> updateAssignment(Long idAssignment, Assignment assignment);
    void deleteAssignment(Long idAssignment);
}
