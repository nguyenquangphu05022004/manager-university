package com.example.manageruniversity.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<T> {
    T saveOrUpdate(T t);
    List<T> records();
    void delete(Long id);
}
