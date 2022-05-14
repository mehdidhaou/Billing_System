package Admin;

import Database.Connector;
import GUI.Session;

import java.sql.SQLException;

public class Affiliation extends Service{
    float unit_cost;
    String pay_interval;
    float tax_ratio;
    int reference;
    int phone;
    public enum AffiliationType {
        SONEDE,
        STEG,
        TOPNET
    }
    public Affiliation(int reference, int phone,  int service_id, AffiliationType service_type) {
        super(service_id, service_type);
        this.reference = reference;
        this.phone = phone;
    }

    public int addAffiliation() throws SQLException {
        String query = "insert into affiliation (user_id, affiliation_id, type, reference) "
                + " values( '" + Session.id + "','" + this.service_id + "','" + this.service_type.toString() + "','" + this.reference + " ')";

        Connector affiliationRegister = new Connector();
        int result = affiliationRegister.create(query);
        affiliationRegister.end();
        return result;
    }


}
