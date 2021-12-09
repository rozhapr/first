package org.statistics.entity;

import javax.persistence.*;

@Entity(name = "person")
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String gender;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String education;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String job;

    public Long getPersonId() { return personId; }

    public void setPersonId(Long personId) { this.personId = personId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFamily() { return family; }

    public void setFamily(String family) { this.family = family; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getEducation() { return education; }

    public void setEducation(String education) { this.education = education; }
    public String getJob() { return job; }

    public void setJob(String job) { this.job = job; }
}