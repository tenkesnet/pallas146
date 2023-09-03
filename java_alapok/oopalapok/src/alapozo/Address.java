package alapozo;

public class Address {
    private String street;
    private String suite;
    private String zipcode;
    private String city;
    private Geo geo;

    public Address(){}
    public Address(String street, String suite, String zipcode, String city, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.zipcode = zipcode;
        this.city = city;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
