package org.academiadecodigo.codezillas.insane.persistence.model;

import org.academiadecodigo.codezillas.insane.AccountType;

public class User extends AbstractUser{

    private String disorder;
    private String mainSkill;
    private AccountType accountType;



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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
