package java_database_capstone.Repository;

import java_database_capstone.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Kerak bo'lsa maxsus qidiruv metodlarini shu yerga qo'shasiz
}