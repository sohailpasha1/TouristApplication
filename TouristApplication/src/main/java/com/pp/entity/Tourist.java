package com.pp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tourist")
public class Tourist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tourist_id")
    @JsonProperty(value = "touristId")
    private Long touristId;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "gender")
    @JsonProperty(value = "gender")
    private String gender;

    @Column(name = "age")
    @JsonProperty(value = "age")
    private Short age;

    @Column(name = "from_place")
    @JsonProperty(value = "fromPlace")
    private String fromPlace;

    @Column(name = "number_of_days_visits")
    @JsonProperty(value = "numberOfDaysVisits")
    private Short numberOfDaysVisits;

    @Column(name = "created_date")
    @JsonProperty(value = "createdDate")
    private Date createdDate;

    public Tourist() {
    }

    public Long getTouristId() {
        return touristId;
    }

    public void setTouristId(Long touristId) {
        this.touristId = touristId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public Short getNumberOfDaysVisits() {
        return numberOfDaysVisits;
    }

    public void setNumberOfDaysVisits(Short numberOfDaysVisits) {
        this.numberOfDaysVisits = numberOfDaysVisits;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "touristId=" + touristId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", fromPlace='" + fromPlace + '\'' +
                ", numberOfDaysVisits='" + numberOfDaysVisits + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
