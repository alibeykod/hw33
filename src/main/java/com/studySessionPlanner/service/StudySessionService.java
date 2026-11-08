package com.studySessionPlanner.service;

import java.util.List;
import java.util.Optional;

public interface StudySessionService<T>{
    T add(T entity);
    T update(T entity , Long id);
    Optional<T> findById(Long id);
    List<T> findAll();
    boolean delete(Long id);

}
