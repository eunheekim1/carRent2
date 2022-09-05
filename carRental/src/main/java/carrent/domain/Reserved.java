package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reserved extends AbstractEvent {

<<<<<<< HEAD
    private Long id;
=======
>>>>>>> origin/template
    private Long rentId;
    private Long carId;
    private Long userId;
    private Date rentStartDate;
    private Date rentEndDate;
    private Date regDate;
    private String status;

    public Reserved(CarRent aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
    // keep

}
