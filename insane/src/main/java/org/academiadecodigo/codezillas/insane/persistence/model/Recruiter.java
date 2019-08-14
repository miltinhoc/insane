package org.academiadecodigo.codezillas.insane.persistence.model;


public class Recruiter extends AbstractUser{

    private String companyName;
    private String searchSkill;



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSearchSkill() {
        return searchSkill;
    }

    public void setSearchSkill(String searchSkill) {
        this.searchSkill = searchSkill;
    }
}
