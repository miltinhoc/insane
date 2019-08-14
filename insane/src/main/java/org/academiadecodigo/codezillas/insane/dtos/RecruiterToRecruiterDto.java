package org.academiadecodigo.codezillas.insane.dtos;

import org.academiadecodigo.codezillas.insane.persistence.model.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecruiterToRecruiterDto {

    /*private Recruiter recruiter;

    @Autowired
    public void setRecruiter(Recruiter recruiter){
        this.recruiter = recruiter;
    }*/

    public RecruiterDto recruiter(Recruiter recruiter) {

        RecruiterDto recruiterDto = new RecruiterDto();

        recruiterDto.setFirstName(recruiter.getFirstName());
        recruiterDto.setLastName(recruiter.getLastName());
        recruiterDto.setCompanyName(recruiter.getCompanyName());
        recruiterDto.setCountry(recruiter.getCountry());
        recruiterDto.setAge(recruiter.getAge());
        recruiterDto.setEmail(recruiter.getEmail());
        recruiterDto.setId(recruiter.getId());
        recruiterDto.setPassword(recruiter.getPassword());
        recruiterDto.setSummary(recruiter.getSummary());

        return recruiterDto;
    }
}
