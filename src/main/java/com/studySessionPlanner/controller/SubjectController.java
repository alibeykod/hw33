package com.studySessionPlanner.controller;

import com.studySessionPlanner.model.Subject;
import com.studySessionPlanner.service.BaseServiceSubject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/subjects")
public class SubjectController {
    private final BaseServiceSubject<Subject> subjectBaseServiceSubject;

    public SubjectController(BaseServiceSubject<Subject> subjectBaseServiceSubject) {
        this.subjectBaseServiceSubject = subjectBaseServiceSubject;
    }

    @GetMapping
    public String getSubjects(Model model){
        model.addAttribute("subjects", subjectBaseServiceSubject.findAll());
        //اسم این کد پایینی چی باید باشه دقیقا اسم همین لیستی که تو اتربیوت خط بالا گذاشتیم یا فرقی نمیکنه ؟؟؟؟
        return "subjects";
    }
}
