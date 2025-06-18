package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    public static MongoDatabase connect() {
        String uri = "mongodb://localhost:27017"; // Default Compass URI
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient.getDatabase("college");
    }
}

