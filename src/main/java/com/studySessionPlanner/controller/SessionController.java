package com.studySessionPlanner.controller;

import com.studySessionPlanner.model.StudySession;
import com.studySessionPlanner.service.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/sessions")
public class SessionController {
    private final StudySessionService<StudySession> studySessionService;

    @Autowired
    public SessionController(StudySessionService<StudySession> studySessionService) {
        this.studySessionService = studySessionService;
    }

    //@RequestMapping Or @GetMapping ????!!!!
    @GetMapping
    public String getAllSessions(Model model) {
        model.addAttribute("sessions", studySessionService.findAll());
        return "session-list";
    }

    @GetMapping("/add")
    public String getForm() {
        return "add-session-form";
    }

    @GetMapping("/detail")
    public String getById(
            @RequestParam("id") Long id,
            Model model) {

        Optional<StudySession> result =
                studySessionService.findById(id);

        if (result.isEmpty()) {
            return "redirect:/sessions";
        }

        model.addAttribute("session", result.get());

        return "session-detail";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("subjectId") Long subjectId,
            @RequestParam("minutes") Integer minutes,
            @RequestParam("notes") String note
    ) {
        StudySession session = new StudySession(subjectId, minutes, note);
        studySessionService.add(session);
        return "redirect:/sessions";
    }

}
