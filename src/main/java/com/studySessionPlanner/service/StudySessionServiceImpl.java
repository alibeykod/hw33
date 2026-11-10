package com.studySessionPlanner.service;

import com.studySessionPlanner.model.StudySession;
import com.studySessionPlanner.repository.StudySessionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudySessionServiceImpl implements StudySessionService<StudySession> {

    private final StudySessionRepositoryImpl studySessionRepository;

    public StudySessionServiceImpl(StudySessionRepositoryImpl studySessionRepository) {
        this.studySessionRepository = studySessionRepository;
    }


    public void validation(StudySession entity) {
        if (entity == null) {
            throw new RuntimeException("Study Session Is Null !!!");
        }
        if (entity.getMinutes() == null || entity.getMinutes() <= 0) {
            throw new RuntimeException("Study Session During Minutes Cant Be Null Or Negative Or Zero !!!");
        }
        if (entity.getNotes() == null || entity.getNotes().isBlank()) {
            throw new RuntimeException("The Notes Of Study Session Cant Be Null OR Empty !!!");
        }
        if (entity.getSubjectId() == null || entity.getSubjectId() <= 0) {
            throw new RuntimeException("Invalid Or Null Subject Id In Study Session Found !!!");
        }
    }

    public void idChecker(Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Negative Or Zero Or Null Id Found !!!");
        }
    }

    @Override
    public StudySession add(StudySession entity) {
        validation(entity);
        Long id = studySessionRepository.findAll().stream()
                .mapToLong(StudySession::getId)
                .max()
                .orElse(0L) + 1;
        return studySessionRepository.add(new StudySession(
                id,
                entity.getSubjectId(),
                entity.getMinutes(),
                entity.getNotes()
        ));
    }

    @Override
    public StudySession update(StudySession entity, Long id) {
        idChecker(id);
        validation(entity);
        StudySession studySessionToUpdate =
                studySessionRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("No Study Session Found With This Id ---> " + id));
        studySessionToUpdate.setMinutes(entity.getMinutes());
        studySessionToUpdate.setNotes(entity.getNotes());
        return studySessionToUpdate;

    }

    @Override
    public Optional<StudySession> findById(Long id) {
        idChecker(id);
        return studySessionRepository.findById(id);
    }

    @Override
    public List<StudySession> findAll() {
        return studySessionRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        idChecker(id);
        return studySessionRepository.delete(id);
    }
}
