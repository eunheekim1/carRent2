package carrent.domain;

import carrent.PaymentApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payId;

    private Long rentId;

    private Double rentCost;

    private String payType;

    private Date payDate;

    @PostPersist
    public void onPostPersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public void pay() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }
}
