package com.litanocg.digitalcourse.controllers;

import com.litanocg.digitalcourse.entities.Course;
import com.litanocg.digitalcourse.entities.dtos.CourseDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping({"/courses"})
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Flux<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Mono<CourseDTO> getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Mono<CourseDTO> createCourse(@Validated @RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Mono<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO course){
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<MessageResponse>> deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id)
                .map(response -> {
                    if (response.getMessage().contains("no existe")) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                    }
                    return ResponseEntity.ok(response);
                });
    }


}
