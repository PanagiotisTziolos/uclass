package com.site.uclass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.uclass.entities.Professor;
import com.site.uclass.services.interfaces.IProfessorService;
import com.site.uclass.util.CustomPage;


@Controller
public class ProfessorController {
    
    @Autowired
    private IProfessorService professorService;

    private CustomPage customPage = new CustomPage();

    private String professor_name;

    private final int ANNOUNCEMENT_PER_PAGE = 4;

    private int currentAnnouncementPage = 0;
    
    @GetMapping("/professors")
    public String professorsView(Model model) {
        model.addAttribute("professors", professorService.getAllProfessors());

        return "professors"; 
    }

    @GetMapping("/professors/{professor_name}")
    public String professorView(Model model, @PathVariable("professor_name") String professor_name) {
        
        Professor professor = getProfessor(professor_name);

        this.professor_name = professor_name;

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

        return "professor_info";
    }

    @PostMapping(value = "/professor_info_next_announcement_page")
    public String nextAnnouncementPage() {

        currentAnnouncementPage += 1;

        return professor_info_page();
    }

    @PostMapping(value = "/professor_info_previous_announcement_page")
    public String previousAnnouncementPage() {
        
        currentAnnouncementPage -= 1;

        return professor_info_page();
    }

    private Professor getProfessor(String name) {
        return professorService.getProfessorByName(name);
    }

    private String professor_info_page() {
        return "redirect:/professors/" + professor_name;
    }
}
