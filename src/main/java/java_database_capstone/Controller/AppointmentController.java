package java_database_capstone.Controller;

import java_database_capstone.Entity.Appointment;
import java_database_capstone.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Uchrashuvga yozilish endpointi
    @PostMapping("/book")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.bookAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    // 25-savol uchun kerak bo'ladigan uchrashuvlarni ko'rish funksiyasi shu yerga qo'shiladi
}
