package com.example;

import static org.junit.Assert.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class GradeGetterTest {

        @Test
        public void testGetCourseGrade() {
                Tutor mom = new Tutor(1, "Rakoto", "Lalao", LocalDate.of(1970, 1, 1),
                                "lalao.rakoto@gmail.com", "0341234567", "mom");

                Student tiana = new Student(1, "Rasoanaivo", "Tiana", LocalDate.of(2000, 5, 20),
                                "tiana.rasoanaivo@gmail.com", "0334567812", "G1", mom);

                Student fara = new Student(2, "Rasoanaivo", "Fara", LocalDate.of(2001, 8, 12),
                                "fara.rasoanaivo@gmail.com", "0389213456", "G1", mom);

                Teacher mamy = new Teacher(1, "Randria", "Mamy", LocalDate.of(1980, 3, 10),
                                "mamy.randria@gmail.com", "0326789034", "Back-end");

                Course prog2 = new Course(1, "PROG2", 5, mamy);

                Exam midterm = new Exam(1, "Midterm", prog2, Instant.now(), 2);

                Grades tianasGrade = new Grades(tiana, midterm, 10.0);
                Instant changeTime = Instant.now().plusSeconds(3600);
                tianasGrade.addChange(15.0, changeTime, "Bonus fanampiny");

                GradeGetter gradeGetter = new GradeGetter(List.of(tianasGrade));

                assertEquals(10.0, gradeGetter.getExamGrade(midterm, tiana, Instant.now()), 0.01);
                assertEquals(15.0, gradeGetter.getExamGrade(midterm, tiana, changeTime.plusSeconds(10)), 0.01);

                assertEquals(0.0, gradeGetter.getExamGrade(midterm, fara, Instant.now()), 0.01);
                assertEquals(0.0, gradeGetter.getCourseGrade(prog2, fara, Instant.now()), 0.01);
        }

        @Test
        public void testGetExamGrade() {
                Tutor mom = new Tutor(1, "Rakoto", "Lalao", LocalDate.of(1970, 1, 1),
                                "lalao.rakoto@gmail.com", "0341234567", "mom");

                Student tiana = new Student(1, "Rasoanaivo", "Tiana", LocalDate.of(2000, 5, 20),
                                "tiana.rasoanaivo@gmail.com", "0334567812", "G1", mom);

                Student fara = new Student(2, "Rasoanaivo", "Fara", LocalDate.of(2001, 8, 12),
                                "fara.rasoanaivo@gmail.com", "0389213456", "G1", mom);

                Teacher mamy = new Teacher(1, "Randria", "Mamy", LocalDate.of(1980, 3, 10),
                                "mamy.randria@gmail.com", "0326789034", "Back-end");

                Course prog2 = new Course(1, "PROG2", 5, mamy);

                Exam exam1 = new Exam(1, "Midterm", prog2, Instant.now(), 2);
                Exam exam2 = new Exam(2, "Final", prog2, Instant.now(), 3);

                Grades g1 = new Grades(tiana, exam1, 10.0);
                Grades g2 = new Grades(tiana, exam2, 15.0);

                GradeGetter gradeGetter = new GradeGetter(List.of(g1, g2));

                assertEquals(13.0, gradeGetter.getCourseGrade(prog2, tiana, Instant.now()), 0.01);

                assertEquals(0.0, gradeGetter.getCourseGrade(prog2, fara, Instant.now()), 0.01);
        }
}
