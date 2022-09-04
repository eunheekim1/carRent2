package carrent.infra;

import carrent.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CarRentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CarRent>> {

    @Override
    public EntityModel<CarRent> process(EntityModel<CarRent> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/reservecancel")
                .withRel("reservecancel")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/return")
                .withRel("return")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/rent")
                .withRel("rent")
        );

        return model;
    }
}
