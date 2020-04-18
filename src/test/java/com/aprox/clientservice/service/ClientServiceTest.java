package com.aprox.clientservice.service;

import com.aprox.clientservice.exceptions.ClientNotFoundException;
import com.aprox.clientservice.model.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    private static ClientService staticClientService;

    private static Client testClient;

    private Client createTestClient(){
        Client client = new Client();

        client.setId(null);
        client.setConsumptions(null);

        client.setPhone2("123456789");
        client.setPhone1("123456789");
        client.setCompanyName("Aprox");
        client.setRepresentativeLastName("Sesterheim");
        client.setRepresentativeFirstName("Guilherme");
        client.setCNPJ("12345678901234");

        return client;
    }

    private Client createUpdateTestClient(){
        Client client = new Client();

        client.setId(null);
        client.setConsumptions(null);

        client.setPhone2("987654321");
        client.setPhone1("987654321");
        client.setCompanyName("Aprox2");
        client.setRepresentativeLastName("Guilherme");
        client.setRepresentativeFirstName("Sesterheim");
        client.setCNPJ("43210987654321");

        return client;
    }

    /*
     Also available methods:
        @BeforeAll
        @BeforeEach
        @Test
        @AfterEach
        @AfterAll << Use it to clean database if an unexpected exception occurs

        @Disabled << will skip that given test
        @Nested << Put on top of a class within this same class. All the tests inside the new class will be shown more organized in the output

     */

    @Test
    @Order(1)
    void shouldCreateClient(){
        staticClientService = this.clientService;

        Client newClient = createTestClient();

        Client createdClient = clientService.createClient(newClient);
        testClient = createdClient;

        assertAll(
            () -> assertNotNull(createdClient, "Could not create a client. Check your database connection, schemas, " +
                "flyway and tables"),
            () -> assertNotNull(createdClient.getId(), "Could not create a client. Check your database connection, " +
                "schemas, flyway and tables"),
            () -> assertEquals("Guilherme", createdClient.getRepresentativeFirstName(), "Client creation " +
                "occurred, but a wrong representative first name was received as a response"),
            () -> assertEquals("12345678901234", createdClient.getCNPJ(), "Client creation occurred, " +
                "but a wrong CNPJ was received as a response")
        );
    }

    @Test
    @Order(2)
    void shouldFindClient(){
        Client foundClient = clientService.getOne(testClient.getId());

        assertNotNull(foundClient, "The recently created client wasn't found. ID: "+testClient.getId());
    }

    @Test
    @Order(3)
    void shouldUpdateClient(){
        Client updatedClient = clientService.updateClient(testClient.getId(), createUpdateTestClient());

        assertNotNull(updatedClient, "There's a problem updated the client information. ID: "+testClient.getId());
        assertEquals("Sesterheim", updatedClient.getRepresentativeFirstName(), "Did not change the client first name correctly. ID: "+testClient.getId());
    }

    @Test
    @Order(4)
    void shouldAddConsumptionToClient() {
        try {
            Integer quantityToBeAdded = 1;
            Client updatedClient = clientService.addConsumption(testClient, quantityToBeAdded);
            assertNotNull(updatedClient, "Did not create the consumption for client ID: "+testClient.getId());
            assertEquals(updatedClient.getConsumptions().size(), 1, "The total number of consumptions " +
                    "for client ID "+testClient.getId()+" is different than expected");
            assertEquals(updatedClient.getConsumptions().get(0).getRequestCount(), quantityToBeAdded, "The " +
                    "request count of the given client consumption is different than expected. Client ID: "+testClient.getId());

        }catch(ClientNotFoundException ce){
            assertTrue(false);
        }
    }

    @Test
    @Order(5)
    void shouldNotAddConsumptionToClient(){
        assertThrows(ClientNotFoundException.class, () -> {clientService.addConsumption((Client) null, 1);},
                "The ClientNotFoundException should have been thrown. Where did this consumption go?");
        assertThrows(ClientNotFoundException.class, () -> {clientService.addConsumption((Long) null, 1);},
                "The ClientNotFoundException should have been thrown. Where did this consumption go?");
    }

    @Test
    @Order(6)
    void shouldDeleteClient(){
        assertDoesNotThrow(() -> {clientService.deleteClient(this.testClient.getId());}, "The client ID " +
                testClient.getId()+" was not deleted. Check the database!");
        testClient = null;
    }

    @Test
    @Order(7)
    void shouldFindAllClients(){
        List<Client> clients = clientService.findAll();

        assertNotNull(clients, "Not clients were found. Check your database connection, schemas, flyway " +
                "and tables");

        assertTrue(clients.size() > 0);
    }

    @Test
    @Order(8)
    void shouldNotCreateClient(){
        Client newClient = createTestClient();
        newClient.setCNPJ(null);

        Throwable error = assertThrows(Throwable.class, () -> {
            clientService.createClient(newClient);
        }, "Should not allow to create a client with no given CNPJ");
        assertEquals("could not execute statement; SQL [n/a]; constraint [null]; nested exception is " +
                "org.hibernate.exception.ConstraintViolationException: could not execute statement",
                error.getMessage());
    }

    @AfterAll
    static void cleanDatabase(){
        if(testClient != null)
            staticClientService.deleteClient(testClient.getId());
    }
}