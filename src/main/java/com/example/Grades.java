package com.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Grades {
        private Student student;
        private Exam exam;
        private double initialValue;
        private List<ChangeOfGrades> history = new ArrayList<>();

        public Grades(Student student, Exam exam, double initialValue) {
                this.student = student;
                this.exam = exam;
                this.initialValue = initialValue;
        }

        public void addChange(double newValue, Instant when, String reason) {
                history.add(new ChangeOfGrades(newValue, when, reason));
        }

        public double getValueAt(Instant t) {
                double value = initialValue;
                for (ChangeOfGrades c : history) {
                        if (!c.getTimestamp().isAfter(t)) {
                                value = c.getValue();
                        }
                }
                return value;
        }

        public Student getStudent() {
                return student;
        }

        public Exam getExam() {
                return exam;
        }
}
