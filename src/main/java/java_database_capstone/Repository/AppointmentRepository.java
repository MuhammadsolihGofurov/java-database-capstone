package java_database_capstone.Repository;

import java_database_capstone.Entity.Appointment;
import java_database_capstone.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // 6-savol sharti: Shifokor va sana bo'yicha uchrashuvlarni topish
    List<Appointment> findByDoctorAndAppointmentTimeBetween(
            Doctor doctor,
            LocalDateTime start,
            LocalDateTime end
    );
}