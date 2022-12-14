package sangali.springframework.sfgdi.controllers;

import sangali.springframework.sfgdi.controllers.services.GreetingService;

public class SetterInjectedController {


    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
