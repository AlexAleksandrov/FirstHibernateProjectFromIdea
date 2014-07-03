package dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Administrator on 17.06.2014.
 */
@Entity(name = "Cycles")
public class TwoWheeler extends Vehicle{
    String pedalsType;

    public String getPedalsType() {
        return pedalsType;
    }

    public void setPedalsType(String pedalsType) {
        this.pedalsType = pedalsType;
    }
}
