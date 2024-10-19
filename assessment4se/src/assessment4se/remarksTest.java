package assessment4se;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class remarksTest {

    @Test
    public void testAddRemarkValid() {
        // Test case 1: Valid remark
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertTrue(prescription1.addRemark("The service was excellent and professional.", "client"));
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate2, "Dr. William");
        assertTrue(prescription2.addRemark("This is the customer remark which should be added.", "client"));
    }

    @Test
    public void testAddRemarktooFewWords() {
        // Test case 2: Invalid remark (few words)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addRemark("Nice", "client"));
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addRemark("Good", "client"));
    }

    @Test
    public void testAddRemarksTooManyWords() {
        // Test case 3: Invalid remark (many words)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addRemark("The service was excellent and professional.The service was excellent and professional. The service was excellent and professional. The service was excellent and professional.", "client"));
 
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addRemark("This is the customer remark which should not be added.This is the customer remark which should not be added.This is the customer remark which should not be added.", "client"));
    }

    @Test
    public void testAddRemarkNoUppercase() {
        // Test case 4: Invalid remark (no upper case)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addRemark("the service was excellent and professional.", "client"));
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addRemark("this is the customer remark which should not be added.", "client"));
    }

    @Test
    public void testAddRemarkWrongRemark() {
        // Test case 5: Invalid remark (wrong remark type)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertFalse(prescription1.addRemark("The service was excellent and professional.", "John"));
        
        Date examDate2 = new Date();
        Prescription prescription2 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate2, "Dr. William");
        assertFalse(prescription2.addRemark("The service was excellent and professional.", "other"));
    }

    @Test
    public void testAddRemarkSecondValid() {
        // Test case 6: Valid remark (valid data)
        Date examDate1 = new Date();
        Prescription prescription1 = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate1, "Dr. William");
        assertTrue(prescription1.addRemark("The client liked the service and said is going to become a regular.", "optometrist"));
        
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "Dr. William");
        assertTrue(prescription.addRemark("The customer said he liked how staff was so friendly and cooperative.", "optometrist"));
    }
}

