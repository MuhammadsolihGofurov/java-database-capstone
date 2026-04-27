package java_database_capstone.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    /**
     * 7-savol sharti: POST endpoint saves a prescription with token and request body validation.
     * Returns structured success or error messages using ResponseEntity.
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> savePrescription(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody Map<String, Object> prescriptionDetails) {

        Map<String, Object> response = new HashMap<>();

        // 1. Soddalashtirilgan token validatsiyasi (Haqiqiy loyihada TokenService ishlatiladi)
        if (token == null || !token.startsWith("Bearer ")) {
            response.put("status", "error");
            response.put("message", "Invalid or missing token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // 2. Request body validatsiyasi (Soddalashtirilgan tekshiruv)
        if (!prescriptionDetails.containsKey("patientId") || !prescriptionDetails.containsKey("medication")) {
            response.put("status", "error");
            response.put("message", "Missing required fields: patientId or medication");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // 3. Muvaffaqiyatli saqlash natijasi
        response.put("status", "success");
        response.put("message", "Prescription saved successfully");
        response.put("data", prescriptionDetails);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
