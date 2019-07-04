package org.pb.bean;

/**
 * @author boge.peng
 * @create 2019-04-20 18:28
 */
public class Address {
    private long id;

    private String province;

    private String city;

    private String street;

    public Address(long id) {
        this.id = id;
    }

    public Address(long id, String province, String city, String street) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
