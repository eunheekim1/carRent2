package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private String rentId;
    private String carId;
    private String userId;
    private Date rentStartDate;
    private Date rentEndDate;
    private Date regDate;
    private String status;
    // keep

}
