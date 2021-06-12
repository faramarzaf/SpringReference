package com.database.DatebaseRelations.onetoone.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    /**
     * to handle error in GET method.
     * "Type definition error: [simple type, class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor];
     * nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
     * No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
     * and no properties discovered to create BeanSerializer
     * he problem is that entities are loaded lazily and serialization happens before they get loaded fully.
     *
     *
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /**
     * JoinColumn will create a foreign key linking the User entity with the primary key from the Userprofile entity
     * The @JoinColumn annotation defines the actual physical mapping on the owning side. On the other hand,
     * the referencing side is defined using the mappedBy attribute of the @OneToMany annotation.
     */
    @JoinColumn(name = "up_id")//user_profile id
    private Userprofile userprofile;

    public User() {
    }

    public User(String name, String email, Userprofile userprofile) {
        this.name = name;
        this.email = email;
        this.userprofile = userprofile;
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

    public Userprofile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(Userprofile userprofile) {
        this.userprofile = userprofile;
    }
}
