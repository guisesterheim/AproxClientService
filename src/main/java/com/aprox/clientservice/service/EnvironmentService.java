package com.aprox.clientservice.service;

import com.aprox.clientservice.exceptions.EnvironmentObjectException;
import com.aprox.clientservice.model.Environment;
import com.aprox.clientservice.repository.EnvironmentRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    @Autowired
    private EnvironmentRepository environmentRepository;

    public List<Environment> findAll(){ return environmentRepository.findAll(); }

    public Environment getOne(Long id){ return environmentRepository.getOne(id);}

    public Environment createEnvironment(Environment env) throws EnvironmentObjectException {
        checkEnvironmentData(env);
        return environmentRepository.save(env);
    }

    public Environment updateEnvironment(Long id, Environment environment) throws EnvironmentObjectException {
        checkEnvironmentData(environment);

        environment.setId(id);
        return environmentRepository.save(environment);
    }

    public void deleteEnvironment(Long id){ environmentRepository.deleteById(id);}

    private void checkEnvironmentData(Environment environment) throws EnvironmentObjectException{
        if(Strings.isBlank(environment.getEnvironmentName()))
            throw new EnvironmentObjectException("Environment name cannot be empty");

        if(environment.getEnvironmentName().length() > 100)
            throw new EnvironmentObjectException("Environment name cannot be longer than 100 characters");

        if(Strings.isBlank(environment.getUser()))
            throw new EnvironmentObjectException("User cannot be empty");

        if(environment.getEnvConnectionDescription().length() > 500)
            throw new EnvironmentObjectException("Environment description cannot be longer than 500 characters");

        if(Strings.isBlank(environment.getConnectionString()))
            throw new EnvironmentObjectException("Connection string cannot be empty");

        if(environment.getConnectionString().length() > 500)
            throw new EnvironmentObjectException("Environment connection string cannot be longer than 500 characters");

        if(Strings.isBlank(environment.getConnectionPort()))
            throw new EnvironmentObjectException("Environment port cannot be empty");

        if(environment.getConnectionPort().length() > 4)
            throw new EnvironmentObjectException("Environment port cannot be longer than 4 characters");

        if(Strings.isNotBlank(environment.getConnectionProtocol()) && environment.getConnectionProtocol().length() > 40)
            throw new EnvironmentObjectException("Environment protocol  cannot be longer than 40 characters");

        if(Strings.isBlank(environment.getUser()))
            throw new EnvironmentObjectException("User cannot be empty");

        if(environment.getUser().length() > 50)
            throw new EnvironmentObjectException("Environment user cannot be longer than 50 characters");

        if(Strings.isBlank(environment.getPassword()))
            throw new EnvironmentObjectException("Password cannot be empty");

        if(environment.getPassword().length() > 100)
            throw new EnvironmentObjectException("Environment user cannot be longer than 100 characters");
    }
}
