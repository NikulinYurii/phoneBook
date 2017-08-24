package app.model;

import javax.persistence.*;

/**
 * Created by yurii on 09.07.17.
 */
@Entity(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private int id;

    @Column(name = "contact_name", nullable = false)
    private String name;

    @Column(name = "contact_surname", nullable = false)
    private String surname;

    /*@Column(name = "contact_middlename", nullable = false)
    private String middle_name;*/

    @Column(name = "mobile_phone", nullable = false)
    private String mobile;

    private String home_phone;

    @OneToOne
    private Address address;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Contact() {
    }

    public Contact(String name, String surname/*, String middle_name*/, String mobile_phone) {
        this.name = name;
        this.surname = surname;
        //this.middle_name = middle_name;
        this.mobile = mobile_phone;
    }

    public Contact(String name, String surname/*, String middle_name*/, String mobile_phone, String home_phone, Address address, String email) {
        this.name = name;
        this.surname = surname;
        //this.middle_name = middle_name;
        this.mobile = mobile_phone;
        this.home_phone = home_phone;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /*public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }
*/
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                '}';
    }
}

