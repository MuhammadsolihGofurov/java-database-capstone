package java_database_capstone.Controller;

import java_database_capstone.Entity.Patient;
import java_database_capstone.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<Patient> register(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.registerPatient(patient));
    }

    // Email yoki telefon orqali qidirish endpointi
    @GetMapping("/search")
    public ResponseEntity<Patient> search(@RequestParam(required = false) String email,
                                          @RequestParam(required = false) String phone) {
        return patientService.searchPatient(email, phone)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
