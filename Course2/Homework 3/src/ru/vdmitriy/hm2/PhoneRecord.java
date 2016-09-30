package ru.vdmitriy.hm2;

/**
 * Created by VasilyevD on 30.09.2016.
 */
public class PhoneRecord {
    private String name;
    private String phone;
    private String email;

    public PhoneRecord() {
    }

    public PhoneRecord(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public PhoneRecord(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public  String getInfo(){
        String info="";
        if (this.name != null && !this.name.isEmpty()) {
            info = info.concat(this.name+ "\n");
        }
        if (this.phone != null && !this.phone.isEmpty()) {
            info = info.concat("     Phone: "+this.phone+ "\n");
        }
        if (this.email != null && !this.email.isEmpty()) {
            info = info.concat("     E-mail: "+this.email+ "\n");
        }
        return info;
    }
    /**
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
