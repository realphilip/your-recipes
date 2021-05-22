package htw.berlin.webapp.web;

import htw.berlin.webapp.frontend.Endpoints;
import htw.berlin.webapp.frontend.ViewNames;
import htw.berlin.webapp.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = Endpoints.Site.REGISTER)
    public ModelAndView showRegistrationPage() {
        return new ModelAndView(ViewNames.REGISTER);
    }

    @PostMapping(path = Endpoints.Site.REGISTER)
    public RedirectView handleRegistrationRequest(RegistrationRequest registrationRequest) {
        registrationService.registerUser(registrationRequest);
        return new RedirectView(Endpoints.Site.LOGIN);
    }

    @ModelAttribute(name = "registrationRequest")
    public RegistrationRequest registrationRequest() {
        return new RegistrationRequest();
    }
}