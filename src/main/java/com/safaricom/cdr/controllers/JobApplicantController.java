/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricom.cdr.controllers;

import com.safaricom.cdr.entities.JobApplicant;
import com.safaricom.cdr.exceptions.ResourceNotFoundException;
import com.safaricom.cdr.repositories.JobApplicantRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
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

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/v1")
public class JobApplicantController {
    
    @Autowired
    private JobApplicantRepository jobApplicantRepository;

    @GetMapping("/applicants")
    public List<JobApplicant> getAllApplicants() {
        return jobApplicantRepository.findAll();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<JobApplicant> getApplicantById(@PathVariable(value = "id") Long applicantId)
        throws ResourceNotFoundException {
        JobApplicant applicant = jobApplicantRepository.findById(applicantId)
        .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));
        return ResponseEntity.ok().body(applicant);
    }

    @PostMapping("/applicants")
    public JobApplicant createApplicant(@Valid @RequestBody JobApplicant applicant) {
        return jobApplicantRepository.save(applicant);
    }

    @PutMapping("/applicants/{id}")
    public ResponseEntity<JobApplicant> updateApplicant(@PathVariable(value = "id") Long applicantId,
         @Valid @RequestBody JobApplicant applicantDetails) throws ResourceNotFoundException {
         JobApplicant applicant = jobApplicantRepository.findById(applicantId)
        .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicant.setFirst_name(applicantDetails.getFirst_name());
        applicant.setLast_name(applicantDetails.getLast_name());
        applicant.setEmail(applicantDetails.getEmail());
        applicant.setPhone(applicantDetails.getPhone());
        applicant.setEducation_level(applicantDetails.getEducation_level());
        applicant.setYears_of_experience(applicantDetails.getYears_of_experience());
        final JobApplicant updatedApplicant = jobApplicantRepository.save(applicant);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/applicants/{id}")
    public Map<String, Boolean> deleteApplicant(@PathVariable(value = "id") Long applicantId)
        throws ResourceNotFoundException {
        JobApplicant applicant = jobApplicantRepository.findById(applicantId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + applicantId));

       jobApplicantRepository.delete(applicant);
       Map<String, Boolean> response = new HashMap<>();
       response.put("Job Applicant deleted", Boolean.TRUE);
       return response;
    }
}
