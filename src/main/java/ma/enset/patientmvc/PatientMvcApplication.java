package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import ma.enset.patientmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", "Alaoui", "BE135680", new Date(), false, 102));
            patientRepository.save(new Patient(null, "Amine", "aziz", "BE135180", new Date(), false, 64));
            patientRepository.save(new Patient(null, "Omar", "hamid", "BE135380", new Date(), true, 130));
            patientRepository.save(new Patient(null, "selma", "arije", "BE135650", new Date(), true, 99));

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        }
                ;
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("ismail", "1234", "1234");
            securityService.saveNewUser("user", "1234", "1234");
            securityService.saveNewUser("hassan", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("ismail","USER");
            securityService.addRoleToUser("ismail","ADMIN");
            securityService.addRoleToUser("user","USER");
            securityService.addRoleToUser("hassan","USER");


        };
    }
}