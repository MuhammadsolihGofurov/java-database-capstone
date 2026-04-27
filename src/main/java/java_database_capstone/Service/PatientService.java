package java_database_capstone.Service;

import java_database_capstone.Entity.Patient;
import java_database_capstone.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public Optional<Patient> searchPatient(String email, String phone) {
        return patientRepository.findByEmailOrPhone(email, phone);
    }
}
