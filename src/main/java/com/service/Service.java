package com.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.config.CosmosDBConfig;

@Component
public class Service {
	
	@Autowired
	private CosmosDBConfig graphdbconnection;

	public String executeQuery(String query2) throws InterruptedException, ExecutionException {
		
		System.out.println("Query " + query2);
		// Submitting remote query to the server.
        ResultSet results = graphdbconnection.getClient().submit(query2);
        
        CompletableFuture<List<Result>> completableFutureResults = results.all();
        List<Result> resultList = completableFutureResults.get();
        
        StringBuilder output = new StringBuilder("");
        for (Result result : resultList) {
            System.out.println("\nQuery result:");
            System.out.println(result.toString());
            output.append(result.toString());
        }
        
        return output.toString();
	}

}
