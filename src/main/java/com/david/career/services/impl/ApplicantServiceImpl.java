/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.services.impl;

import com.david.career.dto.ApplicantDTO;
import com.david.career.dto.ApplicantUpdateDTO;
import com.david.career.exceptions.EntityNotFoundException;
import com.david.career.models.Applicant;
import com.david.career.repositories.ApplicantRepository;
import com.david.career.services.ApplicantService;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import javax.transaction.Transactional;

/**
 *
 * @author david
 */
@Service("applicantService")
@Transactional
public class ApplicantServiceImpl implements ApplicantService{
    
    
    private final ApplicantRepository applicantRepository;
    
    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }
    
    

    @Override
    public List<Applicant> getAllApplicants() {
            return (List<Applicant>) applicantRepository.findAll();
    }

    @Override
    public ApplicantDTO addApplicant(ApplicantDTO applicantDTO) {
        
         
         Date now  = new Date();
         
         Applicant applicant =  new Applicant();
         
         applicant.setFirstName(applicantDTO.getFirstName());
         applicant.setLastName(applicantDTO.getLastName());
         applicant.setUsername(applicantDTO.getUsername());
         applicant.setEmail(applicantDTO.getEmail());
         applicant.setPhoneNumber(applicantDTO.getPhoneNumber());
         applicant.setEducationLevel(applicantDTO.getEducationLevel());
         applicant.setYearsOfExperience(applicantDTO.getYearsOfExperience());
         applicant.setPassword(applicantDTO.getPassword());
         applicant.setCreated(now);
         applicant.setModified(now);
         
         applicantRepository.save(applicant);
         
         /*set generated user id to response object */
          applicantDTO.setId(applicant.getId());
          applicantDTO.setPassword("");
          return applicantDTO;
        
    }

    @Override
    public ApplicantDTO getApplicant(UUID id) {
        Applicant applicant = applicantRepository.getOne(id);
       if(Objects.isNull(applicant)){
           throw new EntityNotFoundException(Applicant.class, id);
       }
       return new ApplicantDTO().build(applicant);
    }

    @Override
    public ApplicantDTO updateApplicant(ApplicantUpdateDTO userUpdateDTO, UUID id) {
         Applicant applicant = applicantRepository.getOne(id);
         applicant.setFirstName(userUpdateDTO.getFirstName());
         applicant.setLastName(userUpdateDTO.getLastName());
         applicant.setEmail(userUpdateDTO.getEmail());
         applicant.setPhoneNumber(userUpdateDTO.getPhoneNumber());
         applicant.setEducationLevel(userUpdateDTO.getEducationLevel());
         applicant.setYearsOfExperience(userUpdateDTO.getYearsOfExperience());
         applicant.setPassword(userUpdateDTO.getPassword());
        //Save updated user details
        applicantRepository.save(applicant);
        
        return new ApplicantDTO().build(applicant);
    }

    @Override
    public void deleteApplicant(UUID id) {
        applicantRepository.deleteById(id);
    }

   

}
