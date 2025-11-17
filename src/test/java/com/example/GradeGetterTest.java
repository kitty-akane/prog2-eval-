package com.example;

import static org.junit.Assert.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class GradeGetterTest {

        @Test
        public void testGetCourseGrade() {
                Tutor mom = new Tutor(1, "Smith", "Alice", LocalDate.of(1970, 1, 1),
                                "alice@example.com", "123456", "Mom");
                Student john = new Student(1, "Doe", "John", LocalDate.of(2000, 5, 20),
                                "john@example.com", "1234", "G1", mom);
                Student anna = new Student(2, "Doe", "Anna", LocalDate.of(2001, 8, 12),
                                "anna@example.com", "5678", "G1", mom); // absent student

                Teacher jane = new Teacher(1, "Brown", "Jane", LocalDate.of(1980, 3, 10),
                                "jane@example.com", "5678", "Back-end");
                Course prog2 = new Course(1, "PROG2", 5, jane);

                Exam midterm = new Exam(1, "Midterm", prog2, Instant.now(), 2);

                Grades johnsGrade = new Grades(john, midterm, 10.0);
                Instant changeTime = Instant.now().plusSeconds(3600);
                johnsGrade.addChange(15.0, changeTime, "Extra credit");

                GradeGetter gradeGetter = new GradeGetter(List.of(johnsGrade));

                assertEquals(10.0, gradeGetter.getExamGrade(midterm, john, Instant.now()), 0.01);
                assertEquals(15.0, gradeGetter.getExamGrade(midterm, john, changeTime.plusSeconds(10)), 0.01);

                
                assertEquals(0.0, gradeGetter.getExamGrade(midterm, anna, Instant.now()), 0.01);
                assertEquals(0.0, gradeGetter.getCourseGrade(prog2, anna, Instant.now()), 0.01);
        }

        @Test
        public void testGetExamGrade() {
                Tutor mom = new Tutor(1, "Smith", "Alice", LocalDate.of(1970, 1, 1),
                                "alice@example.com", "123456", "Mom");
                Student john = new Student(1, "Doe", "John", LocalDate.of(2000, 5, 20),
                                "john@example.com", "1234", "G1", mom);
                Student anna = new Student(2, "Doe", "Anna", LocalDate.of(2001, 8, 12),
                                "anna@example.com", "5678", "G1", mom); // absent student

                Teacher jane = new Teacher(1, "Brown", "Jane", LocalDate.of(1980, 3, 10),
                                "jane@example.com", "5678", "Back-end");
                Course prog2 = new Course(1, "PROG2", 5, jane);

                Exam exam1 = new Exam(1, "Midterm", prog2, Instant.now(), 2);
                Exam exam2 = new Exam(2, "Final", prog2, Instant.now(), 3);

                Grades g1 = new Grades(john, exam1, 10.0);
                Grades g2 = new Grades(john, exam2, 15.0);

                GradeGetter gradeGetter = new GradeGetter(List.of(g1, g2));

                assertEquals(13.0, gradeGetter.getCourseGrade(prog2, john, Instant.now()), 0.01);

                assertEquals(0.0, gradeGetter.getCourseGrade(prog2, anna, Instant.now()), 0.01);
        }
}
