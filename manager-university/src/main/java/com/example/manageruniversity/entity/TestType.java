package com.example.manageruniversity.entity;

public enum TestType {
    QUIZ("Trắc nghiệm"), ESSAY("Tự luận");

    private String value;
    TestType(String value) {
        this.value = value;
    }
}
