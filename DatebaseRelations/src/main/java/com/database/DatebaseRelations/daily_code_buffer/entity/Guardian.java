package com.database.DatebaseRelations.daily_code_buffer.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({

        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )

})
public class Guardian {

    /**
     * we don't want this class to be an entity, and we want to have this class in student class.
     * so we use @Embeddable
     */

    private String name;
    private String email;
    private String mobile;

    public Guardian() {
    }

    public Guardian(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String guardianName) {
        this.name = guardianName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String guardianEmail) {
        this.email = guardianEmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String guardianMobile) {
        this.mobile = guardianMobile;
    }
}
