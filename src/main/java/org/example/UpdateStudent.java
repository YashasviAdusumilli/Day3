package org.example;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class UpdateStudent {
    public static void main(String[] args) {
        MongoDatabase db = MongoConnection.connect();
        MongoCollection<Document> students = db.getCollection("students");

        // Update Bob's name to "Bobby"
        students.updateOne(eq("name", "Bob"), set("name", "Bobby"));

        System.out.println("Updated name for Bob -> Bobby");
        System.out.println("NOTE: In embedded enrollments, the name will NOT change automatically.");
    }
}
