package com.studySessionPlanner.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    T add(T entity);
    T update(T entity , Long id);
    Optional<T> findById(Long id);
    List<T> findAll();
    boolean delete(Long id);
}
