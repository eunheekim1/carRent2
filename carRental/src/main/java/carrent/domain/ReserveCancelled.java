package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReserveCancelled extends AbstractEvent {

    private Long rentId;
    private String status;

    public ReserveCancelled(CarRent aggregate) {
        super(aggregate);
    }

    public ReserveCancelled() {
        super();
    }
    // keep

}
