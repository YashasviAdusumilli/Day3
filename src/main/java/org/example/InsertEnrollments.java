package org.example;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class InsertEnrollments {
    public static void main(String[] args) {
        MongoDatabase db = MongoConnection.connect();

        MongoCollection<Document> students = db.getCollection("students");
        MongoCollection<Document> courses = db.getCollection("courses");
        MongoCollection<Document> enrollments = db.getCollection("enrollments");

        // Referenced Enrollment
        ObjectId aliceId = students.find(eq("name", "Alice")).first().getObjectId("_id");
        ObjectId mathId = courses.find(eq("title", "Math")).first().getObjectId("_id");

        Document referenced = new Document("type", "referenced")
                .append("studentId", aliceId)
                .append("courseId", mathId);
        enrollments.insertOne(referenced);

        // Embedded Enrollment
        Document bob = students.find(eq("name", "Bob")).first();
        Document physics = courses.find(eq("title", "Physics")).first();

        Document embedded = new Document("type", "embedded")
                .append("student", bob)
                .append("course", physics);
        enrollments.insertOne(embedded);
    }
}
