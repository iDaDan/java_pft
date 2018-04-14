package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String homePhone;
    private final String email;
    private String group;
    private boolean creation;

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
}
