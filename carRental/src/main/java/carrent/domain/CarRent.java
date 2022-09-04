package carrent.domain;

import carrent.CarRentalApplication;
import carrent.domain.Reserved;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CarRent_table")
@Data
public class CarRent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rentId;

    private String carId;

    private String userId;

    private Date rentStartDate;

    private Date rentEndDate;

    private Date regDate;

    private String status;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        carrent.external.Payment payment = new carrent.external.Payment();
        // mappings goes here
        CarRentalApplication.applicationContext
            .getBean(carrent.external.PaymentService.class)
            .pay(payment);

        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    public static CarRentRepository repository() {
        CarRentRepository carRentRepository = CarRentalApplication.applicationContext.getBean(
            CarRentRepository.class
        );
        return carRentRepository;
    }

    public void reserveCancel() {
        ReserveCancelled reserveCancelled = new ReserveCancelled(this);
        reserveCancelled.publishAfterCommit();
    }

    public void returnCar() {
        Returned returned = new Returned(this);
        returned.publishAfterCommit();
    }

    public void rent() {
        Rented rented = new Rented(this);
        rented.publishAfterCommit();
    }
}
