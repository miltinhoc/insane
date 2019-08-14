package org.academiadecodigo.codezillas.insane.dtos;

import javax.validation.constraints.*;

public class RecruiterDto {

    @NotNull(message = "Companyname is mandatory")
    @NotBlank(message = "Companyname is mandatory")
    @Size(min = 3, max = 64)
    private String companyName;

    //@NotNull(message = "Summary is mandatory")
    //@NotBlank(message = "Summary is mandatory")
    @Size(min = 50, max = 200)
    private String summary;

    @NotNull(message = "Search skill is mandatory")
    @NotBlank(message = "Search skill is mandatory")
    @Size(min = 20, max = 64)
    private String searchSkill;

    private Integer id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 3, max = 64)
    private String password;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    private Integer age;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Country is mandatory")
    @NotBlank(message = "Country is mandatory")
    @Size(min = 3, max = 64)
    private String country;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSearchSkill() {
        return searchSkill;
    }

    public void setSearchSkill(String searchSkill) {
        this.searchSkill = searchSkill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
