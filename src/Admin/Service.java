package Admin;

public class Service {
    int service_id;
    Affiliation.AffiliationType service_type;

    public Service(int service_id, Affiliation.AffiliationType service_type) {
        this.service_id = service_id;
        this.service_type = service_type;
    }

    public int getService_id() {
        return service_id;
    }

    public Affiliation.AffiliationType getService_type() {
        return service_type;
    }
}
