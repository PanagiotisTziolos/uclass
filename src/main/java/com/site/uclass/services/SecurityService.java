package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Account;
import com.site.uclass.repository.ProfessorAccountRepository;

@Service(value = "securityService")
public class SecurityService {
    
    @Autowired
    private ProfessorAccountRepository par;

    public boolean professorMadeAnnouncement(long userId) {

        Account account = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        for (GrantedAuthority grantedAuthority : account.getAuthorities()) {

            if (grantedAuthority.getAuthority().equals("ROLE_STUDENT")) {
                return true;
            }

            if (grantedAuthority.getAuthority().equals("ROLE_PROFESSOR")) {

                return par.findByAccountId(account.getId()).getProfessor().getAnnouncements().stream().filter(a -> a.getId() == userId).findFirst().isPresent();
            }
        }

        return false;
    }
}
