import com.aprox.clientservice.com.aprox.clientservice.service.ClientService;

public class Application {

    public static void main(String args[]){
        ClientService service = new ClientService();

        System.out.println(service.findAll().get(0).getRepresentativeFirstName());
        System.out.println(service.findAll().get(0).getRepresentativeLastName());
    }

}