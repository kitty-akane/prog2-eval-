package com.example;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class GradeGetter {

        private List<Grades> grades;

        public GradeGetter(List<Grades> grades) {
                this.grades = grades;
        }

        public double getExamGrade(Exam exam, Student student, Instant t) {
                return grades.stream()
                                .filter(g -> g.getExam().equals(exam) && g.getStudent().equals(student))
                                .findFirst()
                                .map(g -> g.getValueAt(t))
                                .orElse(0.0);
        }

        public double getCourseGrade(Course course, Student student, Instant t) {
                List<Grades> examGrades = grades.stream()
                                .filter(g -> g.getExam().getCourse().equals(course)
                                                && g.getStudent().equals(student))
                                .collect(Collectors.toList());

                double weightedSum = 0;
                int totalCoeff = 0;

                for (Grades g : examGrades) {
                        double v = g.getValueAt(t);
                        int c = g.getExam().getCoefficient();
                        weightedSum += v * c;
                        totalCoeff += c;
                }

                return totalCoeff == 0 ? 0 : weightedSum / totalCoeff;
        }
}