package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReserveCancelled extends AbstractEvent {

    private Long rentId;
    private Long carId;
    private String status;
    private Date rentStartDate;
    private Date rentEndDate;
    // keep

}
