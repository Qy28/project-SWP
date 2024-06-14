package Models;

import java.util.Date;

public class Person {
    private String Pid, name, passWord, phoneNumber;
    private Date dob;
    private int role;

    public Person() {
    }

    public Person(String Pid, String name, String passWord, Date dob, String phoneNumber, int role) {
        this.Pid = Pid;
        this.name = name;
        this.passWord = passWord;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" + "Pid=" + Pid + ", name=" + name + ", passWord=" + passWord + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", role=" + role + '}';
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
