package com.aprox.clientservice.service;

import com.aprox.clientservice.exceptions.ConnectionObjectException;
import com.aprox.clientservice.model.Connection;
import com.aprox.clientservice.repository.ConnectionRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;

    public List<Connection> findAll(){ return connectionRepository.findAll(); }

    public Connection getOne(Long id){ return connectionRepository.getOne(id);}

    public Connection createConnection(Connection connection) throws ConnectionObjectException {
        checkConnectionData(connection);
        return connectionRepository.saveAndFlush(connection);
    }

    public Connection updateConnection(Long id, Connection connection) throws ConnectionObjectException {
        checkConnectionData(connection);

        connection.setId(id);
        return connectionRepository.saveAndFlush(connection);
    }

    public void deleteConnection(Long id){ connectionRepository.deleteById(id);}

    private void checkConnectionData(Connection connection) throws ConnectionObjectException {
        if(connection.getEnvironmentA() == null || Strings.isBlank(connection.getEnvironmentA().getEnvironmentName()))
            throw new ConnectionObjectException("Connection environment A and environment A name cannot be empty");

        if(connection.getEnvironmentB() == null || Strings.isBlank(connection.getEnvironmentB().getEnvironmentName()))
            throw new ConnectionObjectException("Connection environment B and environment B name cannot be empty");

        if(Strings.isNotBlank(connection.getDescription()) && connection.getDescription().length() > 500)
            throw new ConnectionObjectException("Connection name cannot be longer than 500 characters");
    }
}
