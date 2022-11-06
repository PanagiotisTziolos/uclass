package com.site.uclass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.security.core.Authentication;

import com.site.uclass.entities.Account;
import com.site.uclass.entities.Professor;
import com.site.uclass.entities.Student;

import com.site.uclass.services.interfaces.IAnnouncementService;
import com.site.uclass.services.interfaces.IEventService;
import com.site.uclass.services.interfaces.IProfessorService;
import com.site.uclass.services.interfaces.IStudentService;

import com.site.uclass.util.CustomCalendar;
import com.site.uclass.util.CustomPage;

@Controller
public class HomeController {

    @Autowired
    private IProfessorService professorService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IAnnouncementService announcementService;

    @Autowired
    private IEventService eventService;

    private final int COURSES_PER_PAGE = 3;

    private final int ANNOUNCEMENT_PER_PAGE = 4;

    private int currentCoursePage = 0;

    private int currentAnnouncementPage = 0;

    private CustomPage customPage = new CustomPage();

    @GetMapping(value = {"/", "/home" })
    public String homeView(Model model, Authentication authentication) {

        CustomCalendar calendar = new CustomCalendar();
        calendar.addCalendarInfo(model);

        model.addAttribute("eventsOfMonth", eventService.getMonthsEventsFromCurrentDay());

        eventService.getMonthsEventsFromCurrentDay().forEach((k, v) -> System.out.println("\n\n\n" + v + "\n\n\n"));
        
        Account account = (Account) authentication.getPrincipal();

        if (account.hasRole("ROLE_PROFESSOR")) {

            Professor professor = professorService.getProfessorByAccountId(account.getId());

            model.addAttribute("professor", professor);

            model.addAttribute("announcements", 
                customPage.getNextItemsFromList(
                    professor.getAnnouncements().stream().sorted((id1, id2) -> Long.compare(id2.getId(), id1.getId())).toList(),
                    currentAnnouncementPage,
                    ANNOUNCEMENT_PER_PAGE
                )
            );

            model.addAttribute("nextAnnouncementPageExists",
                currentAnnouncementPage < customPage.getTotalPages((double)professor.getAnnouncements().size(), ANNOUNCEMENT_PER_PAGE));

            model.addAttribute("firstAnnouncementPage", currentAnnouncementPage == 0);

            return "professor_home";

        } else /*if (account.hasRole("ROLE_STUDENT"))*/ {

            Student student = studentService.getStudentByAccountId(account.getId());

            model.addAttribute("nextCoursePageExists", 
                currentCoursePage < customPage.getTotalPages((double)student.getRegisteredCourses().size(), COURSES_PER_PAGE));

            model.addAttribute("firstCoursePage", currentCoursePage == 0);

            model.addAttribute("nextAnnouncementPageExists", 
                currentAnnouncementPage < customPage.getTotalPages((double)announcementService.numberOFAnnouncements(), ANNOUNCEMENT_PER_PAGE));

            model.addAttribute("firstAnnouncementPage", currentAnnouncementPage == 0);

            model.addAttribute("studentName", student.getName());

            model.addAttribute("registeredCoursesSize", student.getRegisteredCourses().size());

            model.addAttribute("registeredCourses", 
                customPage.getNextItemsFromList(student.getRegisteredCourses(), currentCoursePage, COURSES_PER_PAGE));

            model.addAttribute("announcements", 
                announcementService.getAnnouncementPage(currentAnnouncementPage, ANNOUNCEMENT_PER_PAGE));

            return "home";
        }
    }

    @PostMapping(value = "/next_course_page")
    public String nextCoursePage() {

        currentCoursePage += 1;

        return "redirect:/home";
    }

    @PostMapping(value = "/previous_course_page")
    public String previousCoursePage() {
        
        currentCoursePage -= 1;

        return "redirect:/home";
    }

    @PostMapping(value = "/next_announcement_page")
    public String nextAnnouncementPage() {

        currentAnnouncementPage += 1;

        return "redirect:/home";
    }

    @PostMapping(value = "/previous_announcement_page")
    public String previousAnnouncementPage() {
        
        currentAnnouncementPage -= 1;

        return "redirect:/home";
    }
}
