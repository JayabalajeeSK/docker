package com.jb.student_app.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jb.student_app.entity.Student;
import com.jb.student_app.repo.StudentRepo;

@RestController
@Controller
public class StudentController {
    
    private StudentRepo repo;
    public StudentController(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents()
    {
        return repo.findAll();
        // return List.of(
        //     new Student(1, "jaya", 22),
        //     new Student(2, "bala", 23),
        //     new Student(3, "tharun", 24)

        // );
    }
    @RequestMapping("/addStudent")
    public void addStudent()
    {
        Student s = new Student();
        s.setName("eva");
        s.setAge(30);
        repo.save(s);
    }
}