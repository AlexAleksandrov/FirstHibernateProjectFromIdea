package dto;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.util.*;

/**
 * Created by Administrator on 10.06.2014.
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name = "UserDetails.SelectByName",query = "SELECT userName from UserDetails where userName = :userNameToFind")
@NamedNativeQuery(name = "UserDetails.SelectNameById",query = "SELECT * FROM UserDetails WHERE User_ID = :ID ",resultClass = UserDetails.class)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    int userId;

    @Column(name = "USER_NAME")
    String userName;

    @Temporal(TemporalType.DATE)
    Date dateOfInput;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
//            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
//            @AttributeOverride(name = "pinCode", column = @Column(name = "OFFICE_PIN_CODE"))
//    })
//    Address officeAddress;

//    @ElementCollection(fetch = FetchType.LAZY)
//    @JoinTable(name = "USER_ADDRESS",joinColumns = {@JoinColumn(name = "USER_ID")})
//    @GenericGenerator(name = "hilo-generator",strategy = "hilo")
//    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator = "hilo-generator", type = @Type(type = "long"))
//    Collection<Address> addresses = new ArrayList<Address>();
//
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @JoinTable(name = "USER_VEHICLES",joinColumns = {@JoinColumn(name = "USER_ID")},inverseJoinColumns = {@JoinColumn(name = "VEHICLE_ID")})
//    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

//    public Collection<Vehicle> getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Collection<Vehicle> vehicle) {
//        this.vehicle = vehicle;
//    }
//
//    public Collection<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(Collection<Address> addresses) {
//        this.addresses = addresses;
//    }

    public Date getDateOfInput() {
        return dateOfInput;
    }

    public void setDateOfInput(Date dateOfInput) {
        this.dateOfInput = dateOfInput;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
