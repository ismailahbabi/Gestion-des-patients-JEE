package ma.enset.patientmvc.sec.service;

import ma.enset.patientmvc.sec.entities.AppRole;
import ma.enset.patientmvc.sec.entities.AppUser;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;

public interface SecurityService  {
    AppUser saveNewUser (String username, String password, String rePassword);
    AppRole saveNewRole (String roleName, String description);
    void addRoleToUser (String username, String roleName);
    void removeRoleFromUser (String username, String roleName);
    AppUser loadUserByUserName (String username);
}
