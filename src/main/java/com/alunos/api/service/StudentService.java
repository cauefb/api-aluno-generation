package com.alunos.api.service;

import com.alunos.api.dtos.StudentDto;
import com.alunos.api.model.Student;
import com.alunos.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(StudentDto studentDto){

        var entity = new Student(

                studentDto.getName(),
                studentDto.getAge(),
                studentDto.getFirstSemesterGrade(),
                studentDto.getSecondSemesterGrade(),
                studentDto.getTeacherName(),
                studentDto.getRoomNumber(),
                Instant.now(),
                null
        );

       return repository.save(entity);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Optional<Student> findById(Long id){
        return repository.findById(id);
    }

    public Student updateStudent(Student student){
        return repository.save(student);
    }

    public void delete (Student student){
        repository.delete(student);
    }
}
