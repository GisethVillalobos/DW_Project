package com.example.TransmiApp.service.impl;

import com.example.TransmiApp.model.Assignment;
import com.example.TransmiApp.repository.AssignmentRepository;
import com.example.TransmiApp.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Optional<Assignment> getAssignmentById(Long idAssignment) {
        return assignmentRepository.findById(idAssignment);
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Optional<Assignment> updateAssignment(Long idAssignment, Assignment assignment) {
        if (assignmentRepository.existsById(idAssignment)) {
            assignment.setIdAssignment(idAssignment);
            return Optional.of(assignmentRepository.save(assignment));
        }
        return Optional.empty();
    }

    @Override
    public void deleteAssignment(Long idAssignment) {
        if (assignmentRepository.existsById(idAssignment)) {
            assignmentRepository.deleteById(idAssignment);
        }
    }
}
