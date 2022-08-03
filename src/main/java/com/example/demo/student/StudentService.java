package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentEmail = studentRepository.findStudentsByEmail(student.getEmail());
        if(studentEmail.isPresent()){
            throw new IllegalStateException(("Email already present"));
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean b = studentRepository.existsById(studentId);
        if(!b){
            throw new IllegalStateException("Student does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
