package carrent.domain;

import carrent.CarMgmtApplication;
import carrent.domain.Registered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CarMgmt_table")
@Data
public class CarMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String model;

    private String type;

    private Date regStartDate;

    private Date regEndDate;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Registered registered = new Registered(this);
        registered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        System.out.println("in onPostUpdate FUNCTION !!!!!!!!!!!!!!!!!11111111111111111111111111");
        RegisterCancelled registerCancelled = new RegisterCancelled(this);
        registerCancelled.setStatus("unavailable");
        registerCancelled.publishAfterCommit();
    }

    public static CarMgmtRepository repository() {
        CarMgmtRepository carMgmtRepository = CarMgmtApplication.applicationContext.getBean(
            CarMgmtRepository.class
        );
        return carMgmtRepository;
    }

    public void registerCancel() {
        System.out.println("in registerCancel FUNCTION !!!!!!!!!!!!!!!!!22222222222222222222222222222");
        RegisterCancelled registerCancelled = new RegisterCancelled(this);
        registerCancelled.setStatus("unavailable");
        registerCancelled.publishAfterCommit();
    }

    public static void carStatusChange(Reserved reserved) {     
        repository().findById(reserved.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(reserved.getStatus());
            repository().save(carMgmt);
         });
    }

    public static void carStatusChange(Rented rented) {
        repository().findById(rented.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(rented.getStatus());
            repository().save(carMgmt);
         });
    }

    public static void carStatusChange(Returned returned) {
        repository().findById(returned.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(returned.getStatus());
            repository().save(carMgmt);
         });
    }

    public static void carStatusChange(ReserveCancelled reserveCancelled) {
        repository().findById(reserveCancelled.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(reserveCancelled.getStatus());
            repository().save(carMgmt);
         });
    }
}
