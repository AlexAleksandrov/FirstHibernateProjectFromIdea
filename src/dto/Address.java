package dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Administrator on 12.06.2014.
 */
@Embeddable
public class Address {
    @Column(name = "USER_CITY")
    private String city;
    @Column(name = "USER_STREET")
    private String street;
    @Column(name = "USER_PIN_CODE")
    private String pinCode;

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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
