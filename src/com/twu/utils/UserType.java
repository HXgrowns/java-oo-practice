package com.twu.utils;

public enum UserType {
    MANAGER("管理员"),
    USER("普通用户");

    private final String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
