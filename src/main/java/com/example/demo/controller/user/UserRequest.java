package com.example.demo.controller.user;

public class UserRequest {
    String firstName;
    String lastName;
    String username;
    String password;

/*    public UserDTO(SignUp signUp) {                 //DTO for Hibernate
        this.firstName = signUp.getFirstName();
        this.lastName = signUp.getLastName();
        this.username = signUp.getUsername();
        this.password = signUp.getPassword();
    }*/

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
