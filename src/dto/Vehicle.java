package dto;

import javax.persistence.*;

/**
 * Created by Administrator on 14.06.2014.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;

    private String vehicleName;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
