package com.kodilla.events.controller;

import com.kodilla.events.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/indexes")
    public ResponseEntity<Map<Integer, String>> getStudentIndexes(
            @RequestParam Integer z, @RequestParam Integer n) throws NoSuchFieldException, IllegalAccessException {
        return ResponseEntity.ok(studentService.findStudentIndexesByReflection(z, n));
    }
}
