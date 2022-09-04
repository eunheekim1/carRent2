package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Returned extends AbstractEvent {

    private Long rentId;
    private String status;
    // keep

}
