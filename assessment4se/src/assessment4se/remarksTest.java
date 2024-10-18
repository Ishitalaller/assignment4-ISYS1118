package assessment4se;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class remarksTest {

    @Test
    public void testAddRemarkValid() {
        // Test case 1: Valid remark
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "William");
        assertTrue(prescription.addRemark("The service was excellent and professional.", "client"));
    }

    @Test
    public void testAddRemarktooFewWords() {
        // Test case 2: Invalid remark
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "William");
        assertTrue(prescription.addRemark("Nice", "client"));
    }

    @Test
    public void testAddRemarksTooManyWords() {
        // Test case 3: Invalid remark
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "William");
        assertTrue(prescription.addRemark("The service was excellent and professional.The service was excellent and professional. The service was excellent and professional. The service was excellent and professional.", "client"));
    }

    @Test
    public void testAddRemarkNoUppercase() {
        // Test case 4: Invalid remark
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "William");
        assertTrue(prescription.addRemark("the service was excellent and professional.", "client"));
    }

    @Test
    public void testAddRemarkWrongRemark() {
        // Test case 5: Invalid remark
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "William");
        assertTrue(prescription.addRemark("The service was excellent and professional.", "John"));
    }

    @Test
    public void testAddRemarkSecondValid() {
        // Test case 6: Valid remark
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "Jane", "Oliver", 
            "1 Koonalda Ave, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "William");
        assertTrue(prescription.addRemark("The client liked the service and said is going to become a regular.", "optometrist"));
    }
}

