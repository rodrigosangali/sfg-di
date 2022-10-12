package sangali.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;
import sangali.springframework.sfgdi.controllers.services.GreetingService;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

}
