package carrent.domain;

import carrent.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class Registered extends AbstractEvent {

    private Long carId;
    private String status;
    private String model;
    private String type;
    private Date regStartDate;
    private Date regEndDate;
}
