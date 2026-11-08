package com.studySessionPlanner.service;

import com.studySessionPlanner.model.StudySession;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudySessionServiceImpl implements StudySessionService<StudySession> {
    private final StudySessionService<StudySession> studySessionService;

    public StudySessionServiceImpl(StudySessionService<StudySession> studySessionService) {
        this.studySessionService = studySessionService;
    }

    public void validation(StudySession studySession) {
        if (studySession == null) {
            throw new RuntimeException("Study Session Is Null !!!");
        }
        if (studySession.getMinutes() == null || studySession.getMinutes() <= 0) {
            throw new RuntimeException("Study Session During Minutes Cant Be Null Or Negative Or Zero !!!");
        }
        if (studySession.getNotes() == null || studySession.getNotes().isBlank()) {
            throw new RuntimeException("The Notes Of Study Session Cant Be Null OR Empty !!!");
        }
        if (studySession.getSubjectId() == null || studySession.getSubjectId() <= 0) {
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
        Long id = studySessionService.findAll().stream()
                .mapToLong(StudySession::getId)
                .max()
                .orElse(0L) + 1;
        return studySessionService.add(new StudySession(
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
                studySessionService
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("No Study Session Found With This Id ---> " + id));
        studySessionToUpdate.setMinutes(entity.getMinutes());
        studySessionToUpdate.setNotes(entity.getNotes());
        return studySessionToUpdate;

    }

    @Override
    public Optional<StudySession> findById(Long id) {
        idChecker(id);
        return studySessionService.findById(id);
    }

    @Override
    public List<StudySession> findAll() {
        return studySessionService.findAll();
    }

    @Override
    public boolean delete(Long id) {
        idChecker(id);
        return studySessionService.delete(id);
    }
}
