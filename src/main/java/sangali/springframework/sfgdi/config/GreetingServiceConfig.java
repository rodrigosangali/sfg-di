package sangali.springframework.sfgdi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import sangali.springframework.pets.PetService;
import sangali.springframework.pets.PetServiceFactory;
import sangali.springframework.sfgdi.repositories.EnglishGreetingRepository;
import sangali.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import sangali.springframework.sfgdi.services.*;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(){
        return petServiceFactory().getPetService("dog");
    }
    @Profile({"cat"})
    @Bean
    PetService catPetService(){
        return petServiceFactory().getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    i18nSpanishService i18nSpanishService(){
        return  new i18nSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }


}
