package carrent.domain;

import carrent.domain.*;
import carrent.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Registered extends AbstractEvent {

    private Long userId;
    private String userName;
    private Date birthDate;
    private String phoneNo;
    private Integer age;
    private Double mileagePoint;

    public Registered(MemberMgmt aggregate) {
        super(aggregate);
    }

    public Registered() {
        super();
    }
    // keep

}
