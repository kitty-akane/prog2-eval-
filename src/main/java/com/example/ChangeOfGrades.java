package com.example;

import java.time.Instant;

public class ChangeOfGrades {
        private double value;
        private Instant timestamp;
        private String reason;

        public ChangeOfGrades(double value, Instant timestamp, String reason) {
                this.value = value;
                this.timestamp = timestamp;
                this.reason = reason;
        }

        public double getValue() {
                return value;
        }

        public Instant getTimestamp() {
                return timestamp;
        }

        public String getReason() {
                return reason;
        }
        
}
