package carrent.domain;

import carrent.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class Reserved extends AbstractEvent {

    private Long rentId;
    private Long carId;
    private Long userId;
    private Date rentStartDate;
    private Date rentEndDate;
    private Date regDate;
    private String status;
    private Long rentCost;
}
