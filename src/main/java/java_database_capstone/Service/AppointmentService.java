package java_database_capstone.Service;

import java_database_capstone.Entity.Appointment;
import java_database_capstone.Entity.Doctor;
import java_database_capstone.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // 6-savol sharti: Implements a booking method that saves an appointment
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // 6-savol sharti: Defines a method to retrieve appointments for a doctor on a specific date
    public List<Appointment> getAppointmentsByDoctorAndDate(Doctor doctor, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        return appointmentRepository.findByDoctorAndAppointmentTimeBetween(doctor, startOfDay, endOfDay);
    }
}
