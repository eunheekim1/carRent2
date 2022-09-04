package carrent.infra;

import carrent.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/carRents")
@Transactional
public class CarRentController {

    @Autowired
    CarRentRepository carRentRepository;

    @RequestMapping(
        value = "carRents/{id}/reservecancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public CarRent reserveCancel(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /carRent/reserveCancel  called #####");
        Optional<CarRent> optionalCarRent = carRentRepository.findById(id);

        optionalCarRent.orElseThrow(() -> new Exception("No Entity Found"));
        CarRent carRent = optionalCarRent.get();
        carRent.reserveCancel();

        carRentRepository.save(carRent);
        return carRent;
    }

    @RequestMapping(
        value = "carRents/{id}/return",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public CarRent returnCar(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /carRent/returnCar  called #####");
        Optional<CarRent> optionalCarRent = carRentRepository.findById(id);

        optionalCarRent.orElseThrow(() -> new Exception("No Entity Found"));
        CarRent carRent = optionalCarRent.get();
        carRent.returnCar();

        carRentRepository.save(carRent);
        return carRent;
    }

    @RequestMapping(
        value = "carRents/{id}/rent",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public CarRent rent(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /carRent/rent  called #####");
        Optional<CarRent> optionalCarRent = carRentRepository.findById(id);

        optionalCarRent.orElseThrow(() -> new Exception("No Entity Found"));
        CarRent carRent = optionalCarRent.get();
        carRent.rent();

        carRentRepository.save(carRent);
        return carRent;
    }
    // keep
}
