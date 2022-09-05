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

    private Boolean status;

    @PostPersist
    public void onPostPersist() {
        Registered registered = new Registered(this);
        registered.publishAfterCommit();
<<<<<<< HEAD
=======
    }

    @PostRemove
    public void onPostRemove() {
        RegisterCancelled registerCancelled = new RegisterCancelled(this);
        registerCancelled.publishAfterCommit();
>>>>>>> origin/template
    }

    public static CarMgmtRepository repository() {
        CarMgmtRepository carMgmtRepository = CarMgmtApplication.applicationContext.getBean(
            CarMgmtRepository.class
        );
        return carMgmtRepository;
    }

    public void registerCancel() {
        RegisterCancelled registerCancelled = new RegisterCancelled(this);
        registerCancelled.publishAfterCommit();
    }

    public static void carStatusChange(Reserved reserved) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();
        repository().save(carMgmt);

        */

        /** Example 2:  finding and process */
        
        repository().findById(reserved.getCarId()).ifPresent(carMgmt->{
            repository().save(carMgmt);
         });
    }

    public static void carStatusChange(Rented rented) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();
        repository().save(carMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(rented.get???()).ifPresent(carMgmt->{
            
            carMgmt // do something
            repository().save(carMgmt);


         });
        */

    }

    public static void carStatusChange(Returned returned) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();
        repository().save(carMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(returned.get???()).ifPresent(carMgmt->{
            
            carMgmt // do something
            repository().save(carMgmt);


         });
        */

    }

    public static void carStatusChange(ReserveCancelled reserveCancelled) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();
        repository().save(carMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(reserveCancelled.get???()).ifPresent(carMgmt->{
            
            carMgmt // do something
            repository().save(carMgmt);


         });
        */

    }
}
