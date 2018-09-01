package ru.stqa.pft.adressbook.model;

public class ContactData {


    private String group;
    private boolean creation;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String homePhone;
    private final String email;
    private final String address;



    private int id;


    public ContactData(String firstname, String middlename, String lastname, String nickname,
                       String address, String homePhone, String email, String Group, boolean creation) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.group = Group;
        this.creation = creation;
        this.address = address;


        this.homePhone = homePhone;
    }


    public ContactData(int id, String firstname, String middlename, String lastname, String nickname,
                       String address, String homePhone, String email, String Group, boolean creation) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.group = Group;
        this.creation = creation;
        this.address = address;

        this.homePhone = homePhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }



}

