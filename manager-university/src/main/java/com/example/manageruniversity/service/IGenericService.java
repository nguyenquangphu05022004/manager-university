package com.example.manageruniversity.service;

import java.util.List;

public interface IGenericService<T> {
    T saveOrUpdate(T t);
    List<T> records();
}
