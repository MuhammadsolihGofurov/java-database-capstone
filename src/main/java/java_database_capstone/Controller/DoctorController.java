package java_database_capstone.Controller;

import java_database_capstone.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // 5-savol sharti: GET endpoint for doctor availability using dynamic parameters
    @GetMapping("/{id}/availability")
    public ResponseEntity<List<String>> getDoctorAvailability(@PathVariable Long id) {
        List<String> availability = doctorService.getAvailableTimeSlots(id);

        // ResponseEntity orqali structured response qaytarish
        return ResponseEntity.ok(availability);
    }

    // Login uchun misol endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String name) {
        if (doctorService.validateDoctorLogin(name)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
