package com.example.TransmiApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TransmiApp.model.Assignment;
import com.example.TransmiApp.repository.AssignmentRepository;
import com.example.TransmiApp.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAllAssignments() {
        return (List<Assignment>) assignmentRepository.findAll();
    }

    @Override
    public Assignment getAssignmentById(Long idAssignment) {
        return assignmentRepository.findById(idAssignment).orElse(null);
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment updateAssignment(Long idAssignment, Assignment assignment) {
        Assignment existingAssignment = assignmentRepository.findById(idAssignment).orElseThrow();

        existingAssignment.setBus(assignment.getBus());
        existingAssignment.setDriver(assignment.getDriver());
        existingAssignment.setRoute(assignment.getRoute());
        existingAssignment.setSchedule(assignment.getSchedule());
        
        return assignmentRepository.save(existingAssignment);
    }

    @Override
    public void deleteAssignment(Long idAssignment) {
        if (assignmentRepository.existsById(idAssignment)) {
            assignmentRepository.deleteById(idAssignment);
        }
    }
}
