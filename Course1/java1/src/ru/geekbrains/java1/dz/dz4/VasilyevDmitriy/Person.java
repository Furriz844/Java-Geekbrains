package ru.geekbrains.java1.dz.dz4.VasilyevDmitriy;

/**
 * Created by VasilyevD on 29.08.2016.
 */
public class Person {
    private String name;
    private String jobTitle;
    private String email;
    private String phone;
    private int payment;
    private int age;

    public Person(String name, String job, String email, String phone, int payment, int age){
        setName(name);
        setJobTitle(job);
        setEmail(email);
        setPhone(phone);
        setPayment(payment);
        setAge(age);
    }

    public void printPerson(){
        System.out.println(
                "Name:        "+getName()+
                "\nJob Title:   "+ getJobTitle()+
                "\nEmail:       "+getEmail()+
                "\nPhone:       "+getPhone()+
                "\nPayment:     "+getPayment()+" credits"+
                "\nAge:         "+getAge()+" years old"
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
