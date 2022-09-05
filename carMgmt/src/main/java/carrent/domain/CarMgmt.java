package carrent.domain;

import carrent.CarMgmtApplication;
import carrent.domain.RegisterCancelled;
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
        setStatus("CAR_REGISTERD");
        Registered registered = new Registered(this);
        registered.setStatus("available");
        registered.publishAfterCommit();

        RegisterCancelled registerCancelled = new RegisterCancelled(this);
        registerCancelled.publishAfterCommit();
    }

    public static CarMgmtRepository repository() {
        CarMgmtRepository carMgmtRepository = CarMgmtApplication.applicationContext.getBean(
            CarMgmtRepository.class
        );
        return carMgmtRepository;
    }

<<<<<<< HEAD
    public void registerCancel() {
        setStatus("CAR_REGISTECANCELED");
        RegisterCancelled registerCancelled = new RegisterCancelled(this);
        registerCancelled.setStatus("unavailable");
        registerCancelled.publishAfterCommit();
    }
=======
    public void registerCancel() {}
>>>>>>> origin/template

    public static void carStatusChange(Reserved reserved) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();

        carMgmt.setStatus(reserved.getStatus());

        System.out.println("reserved.getRentId()="+reserved.getRentId());
        System.out.println("reserved.getStatus()="+reserved.getStatus());
        System.out.println("reserved.getCarId()="+reserved.getCarId());

        repository().save(carMgmt);

        */

        //** Example 2:  finding and process 
        
        repository().findByCarId(reserved.getCarId()).ifPresent(carMgmt->{
            carMgmt.setCarId(reserved.getCarId());
            carMgmt.setStatus(reserved.getStatus());
            repository().save(carMgmt);

         });
    }

    public static void carStatusChange(Rented rented) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();

        carMgmt.setCarId(rented.getRentId());
        carMgmt.setStatus("unavailable");

        repository().save(carMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(rented.getCarId()).ifPresent(carMgmt->{
            
            //carMgmt // do something
            repository().save(carMgmt);


         });
        */

        repository().findById(rented.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(rented.getStatus());
            repository().save(carMgmt);
         });
    }

    public static void carStatusChange(Returned returned) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();

        carMgmt.setCarId(returned.getRentId());
        carMgmt.setStatus("available");

        repository().save(carMgmt);

        */

        /**  Example 2:  finding and process
        
        repository().findById(returned.getCarId()).ifPresent(carMgmt->{
            
            //carMgmt // do something
            repository().save(carMgmt);


         });
        */

        repository().findById(returned.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(returned.getStatus());
            repository().save(carMgmt);
         });
    }

    public static void carStatusChange(ReserveCancelled reserveCancelled) {
        /** Example 1:  new item 
        CarMgmt carMgmt = new CarMgmt();

        carMgmt.setCarId(reserveCancelled.getRentId());
        carMgmt.setStatus("available");

        repository().save(carMgmt);

        */

        /**  Example 2:  finding and process
        
        repository().findById(reserveCancelled.getCarId()).ifPresent(carMgmt->{ 
            
            //carMgmt // do something
            repository().save(carMgmt);


         });
        */

        repository().findById(reserveCancelled.getRentId()).ifPresent(carMgmt->{
            carMgmt.setStatus(reserveCancelled.getStatus());
            repository().save(carMgmt);
            
         });
    }
}
