package com.studySessionPlanner.service;

import com.studySessionPlanner.model.Subject;
import com.studySessionPlanner.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements BaseServiceSubject<Subject>{
private final BaseRepository<Subject> subjectRepository ;

    public SubjectServiceImpl(BaseRepository<Subject> subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void validation(Subject subject){
        if (subject == null){
            throw new RuntimeException("The Subject You Send Is Null !!!");
        }
        if (subject.getName() == null || subject.getName().isBlank()){
            throw new RuntimeException("Name Is Null Or Empty !!!");
        }
    }

    public void idChecker(Long id){
        if (id == null || id <= 0){{
            throw new RuntimeException("Id Can Not Be Negative Or Null");
        }}
    }
    @Override
    public Subject add(Subject entity) {
        Long id  = subjectRepository.findAll()
                .stream()
                .mapToLong(Subject::getId)
                .max()
                .orElse(0L)+1;
        validation(entity);
        return new Subject(id , entity.getName());
    }

    @Override
    public Subject update(Subject entity, Long id) {
        idChecker(id);
        Subject subjectToUpdate = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("No Subject Found With This ID => " + id));
        subjectToUpdate.setName(entity.getName());
        return subjectToUpdate;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        idChecker(id);
        Optional<Subject> subjectFound = subjectRepository.findById(id);
        if (subjectFound.isEmpty()){
            throw new RuntimeException("Subject With Id [" + id + "] Has Been Not Found !!!");
        }
        return subjectFound;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        idChecker(id);
        findById(id).orElseThrow(() -> new RuntimeException("No Subject Found With This ID => " + id));
        return subjectRepository.delete(id);
    }
}
