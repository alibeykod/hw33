package com.studySessionPlanner.repository;

import com.studySessionPlanner.model.StudySession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class StudySessionRepositoryImpl implements BaseRepository<StudySession> {
    private static final List<StudySession> sessions = new ArrayList<>();

    static {
        sessions.add(new StudySession(1L, 1L, 20, "Some Notes For Math number 1 : e.g. (2*2 = 4)"));
        sessions.add(new StudySession(2L, 1L, 30, "Some Notes For Math number 2 : e.g. (2/2 = 1)"));

        sessions.add(new StudySession(3L, 2L, 30, "Some Notes For PHYSICS number 1 : e.g. (Newton's First Law)"));
        sessions.add(new StudySession(4L, 2L, 40, "Some Notes For PHYSICS number 2 : e.g. (Newton's Second Law)"));

        sessions.add(new StudySession(5L, 3L, 15, "Some Notes For CS"));
    }

    @Override
    public StudySession add(StudySession entity) {
        sessions.add(entity);
        return entity;
    }

    @Override
    public StudySession update(StudySession entity, Long id) {
        StudySession foundSession = findById(id).orElseThrow(() -> new RuntimeException("This Session Has Been Not Found With This ID " + id));
        foundSession.setMinutes(entity.getMinutes());
        foundSession.setNotes(entity.getNotes());

        return foundSession;
    }

    @Override
    public Optional<StudySession> findById(Long id) {
        Optional<StudySession> session = Optional.empty();
        for (StudySession studySession : sessions) {
            if (studySession.getId().equals(id)) {
                session = Optional.of(studySession);
            }
        }
        return session;
    }

    @Override
    public List<StudySession> findAll() {
        return sessions;
    }

    @Override
    public boolean delete(Long id) {
        StudySession studySessionToRemove = findById(id).orElseThrow(() -> new RuntimeException("This Session Has Been Not Found With This ID " + id));
        if (studySessionToRemove == null) {
            return false;
        }
        sessions.remove(studySessionToRemove);
        return true;
    }
}
