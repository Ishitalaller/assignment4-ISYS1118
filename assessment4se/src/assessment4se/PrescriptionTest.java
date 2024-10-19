package assessment4se;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class PrescriptionTest {

    @Test
    public void testAddPrescriptionValid() {
        // Test case 1: Valid prescription
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertTrue(prescription1.addPrescription());
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 15f, 40f, 1f, examDate2, "Dr. Rosanne");
        assertTrue(prescription2.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidfirstname() {
        // Test case 2: Invalid prescription (FirstName)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(2, "J", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addPrescription());
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(2, "A", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidAddress() {
        // Test case 3: Invalid prescription (Address)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(3, "Jane", "Oliver", 
            "1 Koonalda Ave", 10f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addPrescription());
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(3, "Jane", "Oliver", 
            "Glen Waverly", 10f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidsphere() {
        // Test case 4: Invalid prescription (Sphere value)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(4, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", -30f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addPrescription());
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(4, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 50f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidcylinder() {
        // Test case 5: Invalid prescription (cylinder value)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(5, "James", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 5f, examDate1, "Dr. William");
        assertFalse(prescription1.addPrescription());
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(5, "James", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, -5f, examDate2, "Dr. William");
        assertFalse(prescription2.addPrescription());
    }
    
    @Test
    public void testAddPrescriptionInValidaxis() {
        // Test case 6: Invalid prescription (Axis value)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(6, "James", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 200f, 3f, examDate1, "Dr. William");
        assertFalse(prescription1.addPrescription());
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(6, "James", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 200f, 3f, examDate2, "Dr. William");
        assertFalse(prescription2.addPrescription());
    }

}

