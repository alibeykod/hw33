package com.studySessionPlanner.service;

import com.studySessionPlanner.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BaseServiceSubject <T extends Subject>{
    T add(T entity);
    T update(T entity , Long id);
    Optional<T> findById(Long id);
    List<T> findAll();
    boolean delete(Long id);
}
