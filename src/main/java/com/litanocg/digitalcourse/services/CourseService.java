package com.litanocg.digitalcourse.services;

import com.litanocg.digitalcourse.entities.Course;
import com.litanocg.digitalcourse.entities.dtos.CourseDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.entities.mappers.CourseMapper;
import com.litanocg.digitalcourse.repositories.CategoryRepository;
import com.litanocg.digitalcourse.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private final CourseMapper courseMapper = CourseMapper.INSTANCE;

    public Flux<Course> getAllCourses(){
        return courseRepository.findAll();//.map(courseMapper::toDTO);
    }

    public Mono<CourseDTO> getCourseById(Long id){
        return courseRepository.findById(id).map(courseMapper::toDTO);
    }

    public Mono<CourseDTO> createCourse(CourseDTO courseDTO){
        return categoryRepository.existsById(courseDTO.getCategoryID())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "La categoría especificada no existe."));
                    }
                    Course course = courseMapper.toEntity(courseDTO);
                    return courseRepository.save(course).map(courseMapper::toDTO);
                });
    }

    public Mono<CourseDTO> updateCourse(Long id, CourseDTO courseDTO){
        return courseRepository.findById(id)
                .flatMap(existingCourse ->{
                    existingCourse.setCourseName(courseDTO.getCourseName());
                    existingCourse.setCourseDescription(courseDTO.getCourseDescription());
                    existingCourse.setCoursePrice(courseDTO.getCoursePrice());
                    existingCourse.setCourseDiscount(courseDTO.getCourseDiscount());
                    existingCourse.setCourseImageUrl(courseDTO.getCourseImageUrl());
                    return courseRepository.save(existingCourse).map(courseMapper::toDTO);
                });
    }

    public Mono<MessageResponse> deleteCourse(Long id){
        return courseRepository.findById(id)
                .flatMap(category ->
                        courseRepository.delete(category)
                                .thenReturn(new MessageResponse("El curso fue eliminada correctamente"))
                )
                .switchIfEmpty(Mono.defer(() -> Mono.just(new MessageResponse("El curso con ID " + id + " no existe"))));
    }
}