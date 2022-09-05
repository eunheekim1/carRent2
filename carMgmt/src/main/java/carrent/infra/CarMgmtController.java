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
//@RequestMapping(value="/carMgmts")
@Transactional
public class CarMgmtController {

    @Autowired
    CarMgmtRepository carMgmtRepository;

    @RequestMapping(
        value = "/carMgmts/{id}/registercancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public CarMgmt registerCancel(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /carMgmt/registerCancel  called #####");
        Optional<CarMgmt> optionalCarMgmt = carMgmtRepository.findById(id);

        optionalCarMgmt.orElseThrow(() -> new Exception("No Entity Found"));
        CarMgmt carMgmt = optionalCarMgmt.get();
        carMgmt.registerCancel();

        carMgmtRepository.save(carMgmt);
        return carMgmt;
    }
    // keep
}
