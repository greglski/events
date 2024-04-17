package com.kodilla.events.service;

import com.kodilla.events.domain.Student;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    public static final String INDEX_NUMBER_FIELD_NAME = "indexNumber";
    public static final String DUPLICATE_KEY_COMMUNICATE = "Duplicate key";

    public Map<Integer, String> findStudentIndexesByReflection(Integer z, Integer n) throws NoSuchFieldException, IllegalAccessException {
        Class<Student> studentClassDescriptor = Student.class;
        Field indexNumber = studentClassDescriptor.getDeclaredField(INDEX_NUMBER_FIELD_NAME);
        indexNumber.setAccessible(true);
        Map<Integer, String> identifierToIndex = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Student student = new Student(z);
            if (identifierToIndex.put(student.hashCode(), (String) indexNumber.get(student)) != null) {
                throw new IllegalStateException(DUPLICATE_KEY_COMMUNICATE);
            }
        }
        return identifierToIndex;
    }
}
