package org.academiadecodigo.codezillas.insane.dtos;

import org.academiadecodigo.codezillas.insane.persistence.model.Recruiter;

public class RecruiterDtoToRecruiter {

    @Override
    public Recruiter recruiterDto(RecruiterDto recruiterDto){
        Recruiter recruiter = new Recruiter();

        recruiter.setCompanyName(recruiterDto.getCompanyName());
        recruiter.setSearchSkill(recruiterDto.getSearchSkill());
        recruiter.setFirstName(recruiterDto.getFirstName());
        recruiter.setLastName(recruiterDto.getLastName());
        recruiter.setAge(recruiterDto.getAge());
        recruiter.setCountry(recruiterDto.getCountry());
        recruiter.setEmail(recruiterDto.getEmail());
        recruiter.setPassword(recruiterDto.getPassword());
        recruiter.setSummary(recruiterDto.getSummary());
        recruiter.setId(recruiterDto.getId());

        return recruiter;
    }
}
