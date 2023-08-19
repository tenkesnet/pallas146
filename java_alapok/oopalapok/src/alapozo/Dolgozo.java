package alapozo;

import java.time.LocalDate;
import java.util.Date;

public class Dolgozo {
    int azon;
    String firstName;
    String lastName;
    String gender;
    String country;
    int age;

    Date date;

    int id;

    public Dolgozo(int azonosito, String firstName,
                   String lastName, String gender,
                   String country, int age, Date date, int id){
        this.azon=azonosito;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.country = country;
        this.age=age;
        this.date=date;
        this.id=id;
    }



    public int getAzon() {
        return azon;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dolgozo{" +
                "azon=" + azon +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}