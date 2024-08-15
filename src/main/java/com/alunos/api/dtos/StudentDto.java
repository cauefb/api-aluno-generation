package com.alunos.api.dtos;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Valid
public class StudentDto implements Serializable {

    private static final long serializableVersionUID = 1L;

    @Size(min = 4, max = 60, message = "O nome deve ter entre 4 e 60 caracteres.")
    @NotNull(message = "O Nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @NotNull(message = "A idade não pode ser nula")

    private int age;

    @NotNull(message = "A nota do primeiro semestre não pode ser nula")
    @DecimalMin(value = "0.0", inclusive = true, message = "A nota do segundo semestre deve ser no mínimo 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "A nota do segundo semestre deve ser no máximo 10")
    private double firstSemesterGrade;

    @NotNull(message = "A nota do segundo não pode ser nula")
    @DecimalMin(value = "0.0", inclusive = true, message = "A nota do segundo semestre deve ser no mínimo 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "A nota do segundo semestre deve ser no máximo 10")
    private double secondSemesterGrade;

    @NotNull(message = "O Nome do professor não pode ser nulo")
    @NotBlank(message = "O nome  do professor não pode ser vazio")
    private String teacherName;

    @NotNull(message = "O Nome não pode ser nulo")
    private int roomNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFirstSemesterGrade() {
        return firstSemesterGrade;
    }

    public void setFirstSemesterGrade(double firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSecondSemesterGrade() {
        return secondSemesterGrade;
    }

    public void setSecondSemesterGrade(double secondSemesterGrade) {
        this.secondSemesterGrade = secondSemesterGrade;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
