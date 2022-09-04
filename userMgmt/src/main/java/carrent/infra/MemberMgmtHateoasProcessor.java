package carrent.infra;

import carrent.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MemberMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MemberMgmt>> {

    @Override
    public EntityModel<MemberMgmt> process(EntityModel<MemberMgmt> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/registration")
                .withRel("registration")
        );

        return model;
    }
}
