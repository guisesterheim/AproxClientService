import com.aprox.clientservice.com.aprox.clientservice.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String args[]){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        ClientService service = applicationContext.getBean("clientService", ClientService.class);

        System.out.println(service.findAll().get(0).getRepresentativeFirstName());
        System.out.println(service.findAll().get(0).getSeedNum());
    }

}