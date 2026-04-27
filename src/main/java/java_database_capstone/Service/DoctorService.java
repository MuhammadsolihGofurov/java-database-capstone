package java_database_capstone.Service;

import java_database_capstone.Entity.Doctor;
import java_database_capstone.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // 10-savol sharti: Shifokorning bo'sh vaqtlarini qaytarish
    public List<String> getAvailableTimeSlots(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(Doctor::getAvailableTimes)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    // 10-savol sharti: Login validatsiyasi (Soddalashtirilgan variant)
    public boolean validateDoctorLogin(String name) {
        // Haqiqiy loyihada bu yerda parol tekshiriladi
        return name != null && !name.isEmpty();
    }
}
