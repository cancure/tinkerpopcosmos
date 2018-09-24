package com.config;

import java.io.File;
import java.util.concurrent.ExecutionException;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class CosmosDBConfig {
	
	private Cluster cluster;
	private Client client;
	
    
	public CosmosDBConfig() throws ExecutionException, InterruptedException {
		
	    /**
         * There typically needs to be only one Cluster instance in an application.
        */
        //Cluster cluster;
        
        /**
         * Use the Cluster instance to construct different Client instances (e.g. one for sessionless communication
         * and one or more sessions). A sessionless Client should be thread-safe and typically no more than one is
         * needed unless there is some need to divide connection pools across multiple Client instances. In this case
         * there is just a single sessionless Client instance used for the entire App.
         */
        //Client client;
        
        try {
            // Attempt to create the connection objects
        	File file = ResourceUtils.getFile("classpath:remote.yaml");
            cluster = Cluster.build(file).create();
            client = cluster.connect();
        } catch (Exception e) {
            // Handle file errors.
            System.out.println("Couldn't find the configuration file.");
            e.printStackTrace();
            return;
        }
        
		
	}
		
	public Client getClient() {
		return client;
	}

}
