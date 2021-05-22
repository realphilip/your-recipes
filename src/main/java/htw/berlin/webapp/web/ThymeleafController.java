package htw.berlin.webapp.web;

import htw.berlin.webapp.frontend.Endpoints;
import htw.berlin.webapp.frontend.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

    @GetMapping(path = Endpoints.Site.INDEX)
    public ModelAndView showIndexPage() {
        return new ModelAndView(ViewNames.INDEX);
    }
    @GetMapping(path = Endpoints.Site.LOGIN)
    public ModelAndView showLoginPage() {
        return new ModelAndView(ViewNames.LOGIN);
    }
    @GetMapping(path = Endpoints.Site.REGISTER)
    public ModelAndView showRegisterPage() {
        return new ModelAndView(ViewNames.REGISTER);
    }
    @GetMapping(path = Endpoints.Site.RECIPES)
    public ModelAndView showRecipesPage() {
        return new ModelAndView(ViewNames.RECIPES);
    }
}
