package ru.stqa.pft.adressbook.model;

public class ContactData {


    private String group;
    private int id;
    private boolean creation;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String homePhone;
    private final String email;
    private final String address;
    private final String allPhones;
    private final String lastName;
    private final String firstName;



    public ContactData(String firstname, String middlename, String lastname, String nickname, String homePhone, String email, String Group, boolean creation) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.homePhone = homePhone;
        this.email = email;
        this.group = Group;
        this.creation = creation;
    }


    public ContactData(int id, String lastName, String firstName, String address, String allPhones){
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.firstName = firstName;
        this.allPhones = allPhones;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public boolean isCreation() {
        return creation;
    }

    public String getAddress() {
        return address;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

}

