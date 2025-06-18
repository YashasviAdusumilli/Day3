package org.example;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CreateIndex {
    public static void main(String[] args) {
        MongoDatabase db = MongoConnection.connect();
        MongoCollection<Document> students = db.getCollection("students");

        String indexName = students.createIndex(new Document("name", 1));
        System.out.println("Created index: " + indexName);
    }
}
