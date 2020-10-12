package com.example.webapp.model;

public enum Permission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permissions;

    Permission(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
