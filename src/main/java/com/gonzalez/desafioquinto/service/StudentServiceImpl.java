package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.config.RoleType;
import com.gonzalez.desafioquinto.mapper.StudentMapper;
import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.entity.RoleEntity;
import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import com.gonzalez.desafioquinto.model.request.StudentRequest;
import com.gonzalez.desafioquinto.model.request.UpdateStudentRequest;
import com.gonzalez.desafioquinto.model.response.ListProfessorResponse;
import com.gonzalez.desafioquinto.model.response.ListStudentResponse;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;
import com.gonzalez.desafioquinto.model.response.StudentResponse;
import com.gonzalez.desafioquinto.repository.IRoleRepository;
import com.gonzalez.desafioquinto.repository.IStudentRepository;
import com.gonzalez.desafioquinto.service.abstraction.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IRoleRepository iRoleRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseServiceImpl courseService;

    @Override
    public StudentResponse create(StudentRequest request) throws EntityExistsException {
        if (emailExist(request.getEmail()) == false) {
            StudentEntity student = studentMapper.map(request);
        } else {
            throw new EntityExistsException("Email already in use");
        }
        StudentEntity student = studentMapper.map(request);
        student.setRoles(List.of((iRoleRepository.findByName(RoleType.STUDENT))));
        return studentMapper.map(studentRepository.save(student));
    }

    public Boolean emailExist(String email) {
        Optional<StudentEntity> optional = Optional.ofNullable(studentRepository.findByEmailAndSoftDeleteFalse(email));
        if (optional.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public StudentResponse update(UpdateStudentRequest request) {
        StudentEntity student = getById(request.getId());
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setBirthday(request.getBirthday());
        student.setHistory(request.getHistory());
        List<CourseEntity> courses = new ArrayList<>();
        for (String courseId : request.getIdCourse()) {
            CourseEntity course = courseService.getByIdAndSoftDeleteFalse(courseId);
            courses.add(course);
        }
        student.setCourses(courses);
        return studentMapper.map(student);
    }

    @Override
    public StudentResponse addStudentToCourse(String idStudent, String idCourse) throws Exception {
        StudentEntity student = getById(idStudent);
        CourseEntity course = courseService.getByIdAndSoftDeleteFalse(idCourse);
        if (course.getStudentsList().contains(student)) {
            throw new Exception("this student is already assigned to this course.");
        }
        student.addCourse(course);
        course.addStudent(student);
        return studentMapper.map(student);
    }

    @Override
    public StudentResponse removeStudentFromCourse(String idStudent, String idCourse) throws Exception {
        StudentEntity student = getById(idStudent);
        CourseEntity course = courseService.getByIdAndSoftDeleteFalse(idCourse);
        if (!course.getStudentsList().contains(student)) {
            throw new Exception("this student does not have this course.");
        }
        student.removeCourse(course);
        course.removeStudent(student);
        return studentMapper.map(student);
    }

    private ListStudentResponse buildListResponse(List<StudentEntity> students) {
        List<StudentResponse> responses = studentMapper.map(students);
        ListStudentResponse list = new ListStudentResponse();
        list.setList(responses);
        return list;
    }

    @Override
    public ListStudentResponse getStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return buildListResponse(students);
    }

    @Transactional(rollbackFor = {Exception.class})
    public StudentEntity findByNameAndSoftDeleteFalse(String name) {
        Optional<StudentEntity> opt = Optional.ofNullable(studentRepository.findByName(name));
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Student not found");
        }
        return opt.get();
    }

    @Override
    public StudentResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException {
        return studentMapper.map(findByNameAndSoftDeleteFalse(name));
    }

    @Override
    public StudentEntity getById(String id) throws EntityNotFoundException {
        Optional<StudentEntity> opt = Optional.ofNullable(studentRepository.findByStudentIdAndSoftDeleteFalse(id));
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Course not found");
        }
        return opt.get();
    }

    @Override
    public void delete(String id) throws EntityNotFoundException {
        StudentEntity student = getById(id);
        student.setSoftDelete(true);
        studentRepository.save(student);
    }
}
