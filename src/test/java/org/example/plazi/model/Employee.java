package org.example.plazi.model;

public class Employee {
    private Integer id;
    private String firstName;
    private String pa_surname;
    private String ma_surname;
    private String email;
    private Float salary;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    private String curp;

    public Employee() {

    }

    public Employee(Integer id, String firstName, String pa_surname, String ma_surname, String email, Float salary, String curp) {
        this.id = id;
        this.firstName = firstName;
        this.pa_surname = pa_surname;
        this.ma_surname = ma_surname;
        this.email = email;
        this.salary = salary;
        this.curp = curp;
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

    public String getPa_surname() {
        return pa_surname;
    }

    public void setPa_surname(String pa_surname) {
        this.pa_surname = pa_surname;
    }

    public String getMa_surname() {
        return ma_surname;
    }

    public void setMa_surname(String ma_surname) {
        this.ma_surname = ma_surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", pa_surname='" + pa_surname + '\'' +
                ", ma_surname='" + ma_surname + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary + '\'' +
                ", curp='" + curp +
                '}';
    }
}
