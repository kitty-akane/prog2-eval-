package com.example;

import java.time.LocalDate;

public class Student {
        private int id;
        private String lastName;
        private String firstName;
        private LocalDate birthDate;
        private String email;
        private String phone;
        private String group;
        private Tutor tutor;

        public int getId() {
                return id;
        }

        public String getLastName() {
                return lastName;
        }

        public String getFirstName() {
                return firstName;
        }

        public LocalDate getBirthDate() {
                return birthDate;
        }

        public String getEmail() {
                return email;
        }

        public String getPhone() {
                return phone;
        }

        public String getGroup() {
                return group;
        }

        public Tutor getTutor() {
                return tutor;
        }

        public Student(int id, String lastName, String firstName, LocalDate birthDate,
                        String email, String phone, String group, Tutor tutor) {
                this.id = id;
                this.lastName = lastName;
                this.firstName = firstName;
                this.birthDate = birthDate;
                this.email = email;
                this.phone = phone;
                this.group = group;
                this.tutor = tutor;
        }
}
