package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RegisterCancelled extends AbstractEvent {

    private Long carId;
    private Date regStartDate;
    private Date regEndDate;
    private String status;

    public RegisterCancelled(CarMgmt aggregate) {
        super(aggregate);
    }

    public RegisterCancelled() {
        super();
    }
    // keep

}
