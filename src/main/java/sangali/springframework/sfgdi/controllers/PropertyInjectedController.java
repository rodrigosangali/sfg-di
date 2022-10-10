package sangali.springframework.sfgdi.controllers;

import sangali.springframework.sfgdi.controllers.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
