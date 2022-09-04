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
// @RequestMapping(value="/memberMgmts")
@Transactional
public class MemberMgmtController {

    @Autowired
    MemberMgmtRepository memberMgmtRepository;

    @RequestMapping(
        value = "memberMgmts/{id}/registration",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public MemberMgmt registration(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /memberMgmt/registration  called #####");
        Optional<MemberMgmt> optionalMemberMgmt = memberMgmtRepository.findById(
            id
        );

        optionalMemberMgmt.orElseThrow(() -> new Exception("No Entity Found"));
        MemberMgmt memberMgmt = optionalMemberMgmt.get();
        memberMgmt.registration();

        memberMgmtRepository.save(memberMgmt);
        return memberMgmt;
    }
    // keep
}
