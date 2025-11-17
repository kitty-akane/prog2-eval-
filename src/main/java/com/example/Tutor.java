package com.example;

import java.time.LocalDate;

public class Tutor {
        private int id;
        private String lastName;
        private String firstName;
        private LocalDate birthDate;
        private String email;
        private String phone;
        private String relationDescription;

        public Tutor(int id, String lastName, String firstName, LocalDate birthDate,
                        String email, String phone, String relationDescription) {
                this.id = id;
                this.lastName = lastName;
                this.firstName = firstName;
                this.birthDate = birthDate;
                this.email = email;
                this.phone = phone;
                this.relationDescription = relationDescription;
        }

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

        public String getRelationDescription() {
                return relationDescription;
        }
}
