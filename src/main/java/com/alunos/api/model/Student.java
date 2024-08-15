package com.alunos.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Table(name = "student")
@Entity
public class Student implements Serializable {

    private static final long serializableVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 3)
    private int age;
    @Column(nullable = false)
    private double firstSemesterGrade;

    @Column(nullable = false)
    private double secondSemesterGrade;

    @Column(nullable = false, length = 80)
    private String teacherName;

    @Column(nullable = false)
    private int roomNumber;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant creationTimestamp;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant updateTimestamp;

    public Student() {
    }

    public Student(String name, int age, double firstSemesterGrade, double secondSemesterGrade, String teacherName,
            int roomNumber, Instant creationTimestamp, Instant updateTimestamp) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.firstSemesterGrade = firstSemesterGrade;
        this.secondSemesterGrade = secondSemesterGrade;
        this.teacherName = teacherName;
        this.roomNumber = roomNumber;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(firstSemesterGrade, student.firstSemesterGrade) == 0
                && Double.compare(secondSemesterGrade, student.secondSemesterGrade) == 0
                && roomNumber == student.roomNumber && Objects.equals(id, student.id)
                && Objects.equals(name, student.name) && Objects.equals(teacherName, student.teacherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, firstSemesterGrade, secondSemesterGrade, teacherName, roomNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getFirstSemesterGrade() {
        return firstSemesterGrade;
    }

    public void setFirstSemesterGrade(double firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
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

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
