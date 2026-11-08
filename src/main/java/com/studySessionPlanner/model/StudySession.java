package com.studySessionPlanner.model;

public class StudySession {
    /*
        Each StudySession: id, subjectId, minutes, notes
    */
    private Long id;
    private Long subjectId;
    private Integer minutes;
    private String notes;

    public StudySession(Long id, Long subjectId, Integer minutes, String notes) {
        this.id = id;
        this.subjectId = subjectId;
        this.minutes = minutes;
        this.notes = notes;
    }

    public StudySession(Long subjectId, Integer minutes, String notes) {
        this.subjectId = subjectId;
        this.minutes = minutes;
        this.notes = notes;
    }

    public StudySession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "StudySession{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", minutes=" + minutes +
                ", notes='" + notes + '\'' +
                '}';
    }


}
