package sangali.springframework.sfgdi.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

    @Override
    public String getGretting() {
        return "Hello World - EN";
    }
}
