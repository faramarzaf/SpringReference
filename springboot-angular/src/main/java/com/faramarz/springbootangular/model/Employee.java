package com.faramarz.springbootangular.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    /**
     * The @Column annotation is part of the JPA specification, and you already use all required dependencies.
     * The @NotNull annotation gets defined by the BeanValidation specification.
     */

    /**
     * Reasons to use TEXT:
     *
     *     If you want to store a paragraph or more of text
     *     If you don't need to index the column
     *     If you have reached the row size limit for your table
     *
     * Reasons to use VARCHAR:
     *
     *     If you want to store a few words or a sentence
     *     If you want to index the (entire) column
     *     If you want to use the column with foreign-key constraints
     *

     VARCHAR(X)
     Max Length: variable, up to 65,535 bytes (64KB)
     Case: user name, email, country, subject, password

     TEXT
     Max Length: 65,535 bytes (64KB)
     Case: messages, emails, comments, formatted text, html, code, images, links

     MEDIUMTEXT
     Max Length: 16,777,215 bytes (16MB)
     Case: large json bodies, short to medium length books, csv strings

     LONGTEXT
     Max Length: 4,294,967,29 bytes (4GB)
     Case: textbooks, programs, years of logs files, harry potter and the goblet of fire, scientific research logging
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30, message = "Name should be at least 2 characters up to 30.")
   /* @Column(nullable = false, columnDefinition = "TEXT") columnDefinition --> for example we want text not varchar */
    private String name;

   /* @Column(nullable = false, columnDefinition = "TEXT",unique = true) uniqe address for email*/
    @Email
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String employeeCode;


    public Employee() {

    }

    public Employee(Long id, String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.id = id;
        this.name = name.trim();
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
