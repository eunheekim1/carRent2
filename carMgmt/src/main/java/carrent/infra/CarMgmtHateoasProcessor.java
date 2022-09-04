package carrent.infra;

import carrent.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CarMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CarMgmt>> {

    @Override
    public EntityModel<CarMgmt> process(EntityModel<CarMgmt> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/registercancel")
                .withRel("registercancel")
        );

        return model;
    }
}
