package com.example.TransmiApp.service;

import java.util.List;

import com.example.TransmiApp.model.Assignment;

public interface AssignmentService {
    List<Assignment> getAllAssignments();
    Assignment getAssignmentById(Long idAssignment);
    Assignment createAssignment(Assignment assignment);
    Assignment updateAssignment(Long idAssignment, Assignment assignment);
    void deleteAssignment(Long idAssignment);
}
