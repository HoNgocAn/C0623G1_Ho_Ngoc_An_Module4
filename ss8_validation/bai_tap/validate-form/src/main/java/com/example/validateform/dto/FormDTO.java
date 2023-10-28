package com.example.validateform.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class FormDTO implements Validator {

    @Size(min = 2,message = "Khong duoc it hon 2 ky tư")
    @Size(max = 45,message = "Khong duoc nhieu hon 45 ky tu")
    private String firstName;

    @Size(min = 2,message = "Khong duoc it hon 2 ky tư")
    @Size(max = 45,message = "Khong duoc nhieu hon 45 ky tu")
    private String lastName;

    private String age;

    @Email(message = "Khong dung dinh dang email")
    private String email;


    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})",message = "Khong dung dinh dang so dien thoai")
    private String phoneNumber;

    public FormDTO() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormDTO formDTO = (FormDTO) target;
        LocalDate age = LocalDate.parse(formDTO.getAge());
        if (Period.between(age, LocalDate.now()).getYears() < 18){
            errors.rejectValue("age", "age.under.accept","Khong duoc nho hơn 18 tuoi");
        }
    }
}
