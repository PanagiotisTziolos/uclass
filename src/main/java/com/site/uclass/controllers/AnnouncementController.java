package com.site.uclass.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.uclass.DTO.AnnouncementDTO;
import com.site.uclass.DTO.EventDTO;
import com.site.uclass.entities.Account;
import com.site.uclass.entities.Professor;
import com.site.uclass.services.ProfessorService;
import com.site.uclass.services.interfaces.IAnnouncementService;
import com.site.uclass.services.interfaces.IEventService;
import com.site.uclass.util.CustomCalendar;

@Controller
public class AnnouncementController {
    
    @Autowired
    private IAnnouncementService announcementService;

    @Autowired
    private IEventService eventService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping(value="/announcement{announcementId}")
    public String announcementView(Model model, @PathVariable long announcementId) {
        
        model.addAttribute("announcement", announcementService.getAnnouncementById(announcementId));

        return "announcement";
    }

    @GetMapping(value="/new_announcement")
    public String newAnnouncementView(Model model, Authentication authentication) {

        CustomCalendar calendar = new CustomCalendar();
        calendar.addCalendarInfo(model);

        model.addAttribute("name", loggedProfessor(authentication).getName());

        model.addAttribute("announcementDTO", new AnnouncementDTO());

        return "new_announcement";
    }

    @PostMapping(value = "/make_announcement")
    public String announce(
        Model model, 
        Authentication authentication, 
        @RequestParam String announcementTitle, @RequestParam String announcementMessage,
        @RequestParam(required = false) @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate eventDate,
        @RequestParam(required = false) String eventMessage,
        @RequestParam(defaultValue = "false") boolean createEvent)
    {   

        if (announcementTitle.isEmpty() || announcementMessage.isEmpty()) {

            model.addAttribute("empty_fields", true);
            model.addAttribute("error_message", "Fields cannot be empty");

            return "/new_announcement";
        }

        AnnouncementDTO announcementDTO = new AnnouncementDTO(
            announcementTitle,
            announcementMessage,
            LocalDate.now(),
            loggedProfessor(authentication)
        );
                                                
        if (createEvent) {

            EventDTO eventDTO = new EventDTO(eventDate, eventMessage, announcementDTO);
        
            eventService.save(eventDTO.toEntity());

        } else {

            announcementService.save(announcementDTO.toEntity());
        }

        return "redirect:/home";
    }

    private Professor loggedProfessor(Authentication authentication) {

        Account account = (Account) authentication.getPrincipal();

        return professorService.getProfessorByAccountId(account.getId());
    }
}
