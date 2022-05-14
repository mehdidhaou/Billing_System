package Admin;

public class Company {
    String name, reference, image, website;
    int id;

    public Company(String name, String reference, int id) {
        this.name = name;
        this.reference = reference;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getImage() {
        return image;
    }

    public String getWebsite() {
        return website;
    }

    public int getId() {
        return id;
    }
}
