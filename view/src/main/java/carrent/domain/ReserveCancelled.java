package carrent.domain;

import carrent.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class ReserveCancelled extends AbstractEvent {

    private Long rentId;
    private String status;
}
