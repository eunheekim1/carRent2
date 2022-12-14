package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Registered extends AbstractEvent {

    private Long carId;
    private String status;
    private String model;
    private String type;
    private Date regStartDate;
    private Date regEndDate;

    public Registered(CarMgmt aggregate) {
        super(aggregate);
    }

    public Registered() {
        super();
    }
    // keep

}
