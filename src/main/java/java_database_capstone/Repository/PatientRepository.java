package java_database_capstone.Repository;

import java_database_capstone.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // 8-savol mezon 1: Method retrieves patient by email using derived query
    Optional<Patient> findByEmail(String email);

    // 8-savol mezon 2: Method retrieves patient using either email or phone number
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
