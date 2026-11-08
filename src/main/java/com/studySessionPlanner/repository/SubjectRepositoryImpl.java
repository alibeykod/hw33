package com.studySessionPlanner.repository;

import com.studySessionPlanner.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class SubjectRepositoryImpl implements BaseRepository<Subject> {
    private static final List<Subject> subjects = new ArrayList<>();

    static {
        subjects.add(new Subject(1L, "MATH"));
        subjects.add(new Subject(2L, "PHYSICS"));
        subjects.add(new Subject(3L, "CS"));
    }

    @Override
    public Subject add(Subject entity) {
        subjects.add(entity);
        return entity;
    }

    @Override
    public Subject update(Subject entity, Long id) {
        Subject foundSubject = findById(id).orElseThrow(() -> new RuntimeException("Subject With This ID [" + id + "] Has Been Not Found !!!"));
        foundSubject.setName(entity.getName());
        return foundSubject;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        Optional<Subject> foundSubject = Optional.empty();
        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) {
                foundSubject = Optional.of(subject);
                return foundSubject;
            }
        }
        return foundSubject;
    }

    @Override
    public List<Subject> findAll() {
        return subjects;
    }

    @Override
    public boolean delete(Long id) {
        Subject subject = findById(id).orElseThrow(() -> new RuntimeException("Subject With This ID [" + id + "] Has Been Not Found !!!"));
        if (subject == null) {
            System.out.println("Subject With This ID [" + id + "] Has Been Not Found !!!");
            return false;
        }
        subjects.remove(subject);
        return true;
    }
}
