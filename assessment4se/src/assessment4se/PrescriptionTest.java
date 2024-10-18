package assessment4se;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class PrescriptionTest {

    @Test
    public void testAddPrescriptionValid() {
        // Test case 1: Valid prescription
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "Dr. William");
        assertTrue(prescription.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidfirstname() {
        // Test case 2: Invalid prescription
        Date examDate = new Date();
        Prescription prescription = new Prescription(2, "J", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "Dr. William");
        assertTrue(prescription.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidAddress() {
        // Test case 3: Invalid prescription
        Date examDate = new Date();
        Prescription prescription = new Prescription(3, "Jane", "Oliver", 
            "1 Koonalda Ave", 10f, 20f, 2f, examDate, "Dr. William");
        assertTrue(prescription.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidsphere() {
        // Test case 4: Invalid prescription
        Date examDate = new Date();
        Prescription prescription = new Prescription(4, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", -30f, 20f, 2f, examDate, "Dr. William");
        assertTrue(prescription.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidcylinder() {
        // Test case 5: Invalid prescription
        Date examDate = new Date();
        Prescription prescription = new Prescription(5, "James", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 5f, examDate, "Dr. William");
        assertTrue(prescription.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidaxis() {
        // Test case 6: Invalid prescription
        Date examDate = new Date();
        Prescription prescription = new Prescription(6, "James", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 200f, 3f, examDate, "Dr. William");
        assertTrue(prescription.addPrescription());
    }

}

