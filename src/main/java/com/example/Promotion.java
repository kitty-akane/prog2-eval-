package com.example;

import java.util.HashSet;
import java.util.Set;

public class Promotion {
        private Set<String> groups = new HashSet<>();

        public void addGroup(String g) {
                groups.add(g);
        }

        public Set<String> getGroups() {
                return groups;
        }
}
