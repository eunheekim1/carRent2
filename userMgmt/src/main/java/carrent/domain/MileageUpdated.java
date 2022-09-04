package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MileageUpdated extends AbstractEvent {

    private Long id;
    private String userId;
    private Double mileagePoint;

    public MileageUpdated(MemberMgmt aggregate) {
        super(aggregate);
    }

    public MileageUpdated() {
        super();
    }
    // keep

}
