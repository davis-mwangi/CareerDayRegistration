/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.services;


import com.david.career.dto.ApplicantDTO;
import com.david.career.dto.ApplicantUpdateDTO;
import com.david.career.models.Applicant;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author david
 */
public interface ApplicantService {

    /**
     *
     * @return
     */
    public List<Applicant> getAllApplicants();
    public ApplicantDTO addApplicant(ApplicantDTO applicantDTO);
    public ApplicantDTO getApplicant(UUID id);

    /**
     *
     * @param applicantUpdateDTO
     * @param id
     * @return
     */
    public ApplicantDTO updateApplicant(ApplicantUpdateDTO applicantUpdateDTO, UUID id);
    public void deleteApplicant(UUID id);
}
