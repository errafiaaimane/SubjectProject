package emi.ac.ma.ProjectCours.services;

import emi.ac.ma.ProjectCours.entities.Subject;
import emi.ac.ma.ProjectCours.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;  // Assuming there is a repository interface or class to access the database

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject updateSubject(Long id, Subject subject) {
        // Check if the subject with the given ID exists
        Subject existingSubject = subjectRepository.findById(id).orElse(null);

        if (existingSubject != null) {
            // Update attributes of the existing subject
            existingSubject.setName(subject.getName());
            existingSubject.setDescription(subject.getDescription());
            existingSubject.setCredit(subject.getCredit());
            existingSubject.setTeacher(subject.getTeacher());

            // Save the changes to the database
            return subjectRepository.save(existingSubject);
        }

        return null;  // Return null if the subject is not found
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
