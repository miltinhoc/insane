package org.academiadecodigo.codezillas.insane.dtos;

import javax.validation.constraints.*;

public class UserDto {
    @NotNull(message = "Disorder is mandatory")
    @NotBlank(message = "Disorder is mandatory")
    @Size(min = 3, max = 64)
    private String disorder;
    //@NotNull(message = "Summary is mandatory")
    //@NotBlank(message = "Summary is mandatory")
    @Size(min = 50, max = 200)
    private String summary;
    @NotNull(message = "Mainskill is mandatory")
    @NotBlank(message = "Mainskill is mandatory")
    @Size(min = 3, max = 64)
    private String mainSkill;

    private Integer id;
    @NotNull(message = "firstName is mandatory")
    @NotBlank(message = "firstName is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;
    @NotNull(message = "lastName is mandatory")
    @NotBlank(message = "lastName is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;
    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 3, max = 64)
    private String password;
    @NotNull
    @Min(18)
    private Integer age;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    public String getDisorder() {
        return disorder;
    }

    public void setDisorder(String disorder) {
        this.disorder = disorder;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMainSkill() {
        return mainSkill;
    }

    public void setMainSkill(String mainSkill) {
        this.mainSkill = mainSkill;
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

    public void setFirstName(String firstName) {
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

    private String country;
}
