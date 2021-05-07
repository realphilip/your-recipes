package htw.berlin.webapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
#test
        @RequestMapping("/")
        public String index() {
            return "Welcome to Your Recipes";

        }
    }
