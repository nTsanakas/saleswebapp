package saleswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Alexander Carl on 04.06.2017.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@Autowired
    //private SalesPersonService salesPersonService;
    //salesPersonService.testMethodSaveSalesPerson();

    //ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
    //String sha = shaPasswordEncoder.encodePassword("root", null);
}