package org.example;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class InsertData {
    public static void main(String[] args) {
        MongoDatabase db = MongoConnection.connect();

        MongoCollection<Document> students = db.getCollection("students");
        MongoCollection<Document> courses = db.getCollection("courses");

        // Insert student
        Document student1 = new Document("name", "Alice").append("age", 20);
        Document student2 = new Document("name", "Bob").append("age", 22);
        students.insertOne(student1);
        students.insertOne(student2);

        // Insert course
        Document course1 = new Document("title", "Math").append("credits", 3);
        Document course2 = new Document("title", "Physics").append("credits", 4);
        courses.insertOne(course1);
        courses.insertOne(course2);
    }
}

