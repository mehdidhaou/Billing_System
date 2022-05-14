package App;

import Admin.Affiliation;
import Database.Connector;
import GUI.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class User {

    protected String first_name, last_name, password, email, address;
    protected int user_id, national_id,phone_number;
    protected ArrayList<Affiliation> enrolled;
    protected Date creation_date, date_of_birth;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int user_id, int national_id, String first_name, String last_name, String password, String email, Date creation_date, int phone_number) {
        this.user_id = user_id;
        this.national_id = national_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.creation_date = creation_date;
        this.phone_number = phone_number;
    }

    public Boolean Authorized() throws SQLException {
        String query = "select * from user where email='" + this.email + "' and password='" + this.password + "'";
        Connector login = new Connector();
        ResultSet result = login.read(query);
        if (result.next() == false) {
            login.end();
            return false;
        }
        Session.id = result.getInt("user_id");
        login.end();
        return true;
    }

    public int AddUser() throws SQLException {
        String query = "insert into user (user_id, first_name, last_name ,password, email, phone_number, national_id, creation_date) "
                + " values( '" + this.user_id + "','" + this.first_name + "','" + this.last_name + "','" + this.password + "','" + this.email + "','" + this.phone_number + "','"
                + this.national_id + "','" + this.creation_date + " ')";

        Connector register = new Connector();
        int result = register.create(query);
        register.end();
        return result;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getNational_id() {
        return national_id;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public Date getCreation_date() {
        return creation_date;
    }
}
