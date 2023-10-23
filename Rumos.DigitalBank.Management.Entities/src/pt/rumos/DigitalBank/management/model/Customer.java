package pt.rumos.DigitalBank.management.model;

public class Customer {
    private String username;
    private String password;
    private String name;
    private final int nif;
    private String dateOfBirth;
    private String phoneNumber;
    private String mobileNumber;
    private String email;
    private String profession;

    public Customer(String username, String password, String name, String nif, String dateOfBirth, String phoneNumber, String mobileNumber, String email, String profession) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nif = Integer.parseInt(nif);
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.profession = profession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public int getNif() {
        return nif;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

