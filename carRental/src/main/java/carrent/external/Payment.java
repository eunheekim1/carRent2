package carrent.external;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

    private Long payId;
    private Long rentId;
    private Double rentCost;
    private String payType;
    private Date payDate;
    // keep

}
