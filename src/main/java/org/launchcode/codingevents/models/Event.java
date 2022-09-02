package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters!")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email. Try again!")
    private String contactEmail;

    //Add a field to collect information about where the event will take place. This field should not be null or blank.
    @NotBlank(message = "Location is required!")
    @NotNull(message = "Location is required!")
    private String location;

    //Add a field to collect information about whether an attendee must register for the event or not.
    // For the purposes of validation practice, make this field only able to be marked as true.
    @AssertTrue(message = "The event must have attendees register!")
    private boolean shouldRegister = true;

    //Add a field to collect information about the number of attendees for the event.
    // Valid values for this field should be any number over zero.
    @NotNull(message = "At least one attendees is required!")
    @Min(value=1, message = "At least one attendees is required!")
    private Integer numberOfAttendees;

    @NotNull(message = "Must have # of coursed between 1 and 3")
    @Min(value = 1, message = "Must have # of coursed between 1 and 3")
    @Max(value = 3, message = "Must have # of coursed between 1 and 3")
    private Integer numberOfFoodCourses;

    public Event(String name, String description, String contactEmail, String location, Integer numberOfAttendees) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.id = nextId;
        nextId++;
    }

    public Event(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isShouldRegister() {
        return shouldRegister;
    }

    public void setShouldRegister(boolean shouldRegister) {
        this.shouldRegister = shouldRegister;
    }

    public Integer getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(Integer numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public Integer getNumberOfFoodCourses() {
        return numberOfFoodCourses;
    }

    public void setNumberOfFoodCourses(Integer numberOfFoodCourses) {
        this.numberOfFoodCourses = numberOfFoodCourses;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
