package com.alunos.api.controller;

import com.alunos.api.dtos.StudentDto;
import com.alunos.api.model.Student;
import com.alunos.api.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/v1/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "Criar", description = "Método para criar um novo aluno", tags = "Students")
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDto studentDto){

       var student = service.createStudent(studentDto);

        return status(HttpStatus.CREATED).body(student);
    }

    @Operation(summary = "Listar", description = "Metodo que retona todos os alunos", tags = "Students")
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){

        List<Student> list = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "Busca por id", description = "Método que retona  um unico registro", tags = "Students")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value="id")Long id){

        Optional<Student> student = service.findById(id);

        if(student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }

        return status(HttpStatus.OK).body(student.get());
    }

    @Operation(summary = "Editar", description = "Método para editar um aluno.", tags = "Students")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value="id") Long id,
                                                @RequestBody @Valid StudentDto studentDto) {

        Optional<Student> student = service.findById(id);

        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }

        var studentModel = student.get();
        BeanUtils.copyProperties(studentDto, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStudent(studentModel));
    }

    @Operation(summary = "Deletar", description = "Método para deletar um registro.", tags = "Students")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value="id")Long id){

        Optional<Student> student = service.findById(id);

        if(student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }

        service.delete(student.get());
        return status(HttpStatus.NO_CONTENT).body("Aluno deletado");
    }
}
