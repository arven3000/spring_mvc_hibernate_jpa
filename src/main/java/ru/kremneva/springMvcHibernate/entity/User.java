package ru.kremneva.springMvcHibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Пожалуйста введите ваше имя")
    @Size(min = 2, max = 26, message = "Количество символов в имени должно быть в диапозоне от 2 до 25")
    @Column(name = "name")
    private String firstName;

    @NotBlank(message = "Пожалуйста введите вашу фамилию")
    @Size(min = 1, max = 26, message = "Количество символов в фамилии должно быть в диапозоне от 1 до 25")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Пожалуйста введите ваш email")
    @Email(message = "email должен быть валидным")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "\\+79\\d{2}\\d{3}\\d{2}\\d{2}",
            message = "пожалуйста используйте шаблон +79XXXXXX")
    @Column(name = "phone_number")
    private String phoneNumber;

    public User() {
    }

    public User(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
