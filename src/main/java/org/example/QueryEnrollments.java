package org.example;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class QueryEnrollments {
    public static void main(String[] args) {
        MongoDatabase db = MongoConnection.connect();
        MongoCollection<Document> enrollments = db.getCollection("enrollments");
        MongoCollection<Document> students = db.getCollection("students");
        MongoCollection<Document> courses = db.getCollection("courses");

        MongoCursor<Document> cursor = enrollments.find().iterator();
        while (cursor.hasNext()) {
            Document enrollment = cursor.next();
            String type = enrollment.getString("type");
            System.out.println("\nType: " + type);

            if (type.equals("referenced")) {
                ObjectId studentId = enrollment.getObjectId("studentId");
                ObjectId courseId = enrollment.getObjectId("courseId");
                Document student = students.find(eq("_id", studentId)).first();
                Document course = courses.find(eq("_id", courseId)).first();

                System.out.println("Student: " + student.toJson());
                System.out.println("Course: " + course.toJson());
            } else {
                System.out.println("Student: " + enrollment.get("student"));
                System.out.println("Course: " + enrollment.get("course"));
            }
        }
    }
}

