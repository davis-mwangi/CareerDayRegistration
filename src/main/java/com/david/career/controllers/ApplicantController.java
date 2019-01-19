/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.controllers;

import com.david.career.dto.ApplicantDTO;
import com.david.career.dto.ApplicantUpdateDTO;
import com.david.career.models.Applicant;
import com.david.career.response.SuccessResponse;
import com.david.career.services.ApplicantService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/v1")
public class ApplicantController {
    
    @Autowired
    private ApplicantService applicantService;
    
    @PostMapping
    public ResponseEntity<ApplicantDTO>createApplicant(@Valid @RequestBody ApplicantDTO userDTO){
        return ResponseEntity.ok(applicantService.addApplicant(userDTO));
    }
    
    @GetMapping("/applicants")
    public List<Applicant>getAllApplicants(){
        return applicantService.getAllApplicants();
    }
    
    @GetMapping
    public ResponseEntity<ApplicantDTO> getApplicant(@RequestParam(value = "id") UUID id) {
         return ResponseEntity.ok(applicantService.getApplicant(id));
    }
    
    @PutMapping
    public ResponseEntity<ApplicantDTO> updateApplicant(@Valid @RequestBody ApplicantUpdateDTO 
            userUpdateDTO, @RequestParam(value ="id") UUID id){
        return ResponseEntity.ok(applicantService.updateApplicant(userUpdateDTO, id));
    }
    
    @DeleteMapping
    public ResponseEntity<?>deleteApplicant(@RequestParam(value = "id") UUID id){
        applicantService.deleteApplicant(id);
       return ResponseEntity.ok(new SuccessResponse("deleted"));
    }
    
}
