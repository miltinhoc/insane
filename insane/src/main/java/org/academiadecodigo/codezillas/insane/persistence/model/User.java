package org.academiadecodigo.codezillas.insane.persistence.model;

import org.academiadecodigo.codezillas.insane.AccountType;

public class User extends AbstractUser{

    private String disorder;
    private String mainSkill;



    public String getDisorder() {
        return disorder;
    }

    public void setDisorder(String disorder) {
        this.disorder = disorder;
    }

    public String getMainSkill() {
        return mainSkill;
    }

    public void setMainSkill(String mainSkill) {
        this.mainSkill = mainSkill;
    }


}
