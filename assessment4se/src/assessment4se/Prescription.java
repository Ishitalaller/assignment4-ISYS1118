package assessment4se; //package declaration
import java.io.*; 
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Prescription {
	//Private variables to store prescription details
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;

    //Array list to hold remarks
    private ArrayList<String> remarksList = new ArrayList<>(); 

    // Constructor to initialize Prescription object
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, float axis, float cylinder, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    
    // Method to add prescription to a TXT file
    public boolean addPrescription() {

        // Check if all the data meet the conditions
        if (firstName.length() >= 4 && firstName.length() <= 15 &&
            lastName.length() >= 4 && lastName.length() <= 15 &&
            address.length() >= 20 &&
            sphere >= -20.00 && sphere <= 20.00 &&
            cylinder >= -4.00 && cylinder <= 4.00 &&
            axis >= 0 && axis <= 180 &&
            optometrist.length() >= 8 && optometrist.length() <= 25) {

            // If conditions are met, write the prescription details to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("prescption.txt", true))) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                writer.write("Prescription ID: " + prescID + "\n");
                writer.write("First Name: " + firstName + "\n");
                writer.write("Last Name: " + lastName + "\n");
                writer.write("Address: " + address + "\n");
                writer.write("Sphere: " + sphere + "\n");
                writer.write("Cylinder: " + cylinder + "\n");
                writer.write("Axis: " + axis + "\n");
                writer.write("Examination Date: " + sdf.format(examinationDate) + "\n");
                writer.write("Optometrist: " + optometrist + "\n");
                writer.write("\n");
                return true; // Information successfully added
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception
            }
        }
        return false; // If any condition is not met
    }

//     Method to add a remark to a TXT file
    public boolean addRemark(String remark, String remarkType) {
        // Check if the remark meets the conditions
        if (remark.split("\\s+").length >= 6 && remark.split("\\s+").length <= 20 &&
            Character.isUpperCase(remark.charAt(0)) &&
            (remarkType.equalsIgnoreCase("Client") || remarkType.equalsIgnoreCase("Optometrist")) &&
            remarksList.size() < 2) {

            // Add remark to the remarksList list
        	remarksList.add(remark);
            


            // Write the remark to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("remarks.txt", true))) {
                writer.write("Prescription ID: " + prescID + "\n");
                writer.write("Remark: " + remark + "\n");
                writer.write("Remark Type: " + remarkType + "\n");
                writer.write("\n");
                return true; // Remark successfully added
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception
            }
        }
        return false; // If any condition is not met
    }

    // Main method 
    public static void main(String[] args) {
        // Create a prescription object with valid details
        Date examDate = new Date();
        Prescription prescription = new Prescription(1, "James", "Oliver", "1 Koonalda Avenue, Glen Waverly, 1001", 10f, 20f, 2f, examDate, "Dr. William");
        

        // Add prescription and check if it's successfully saved
        if (prescription.addPrescription()) {
            System.out.println("Prescription added successfully!");
        } else {
            System.out.println("Failed to add prescription.");
        }

        
          
//         Add valid remark
        if (prescription.addRemark("This client is happy with the service.", "Client")) {
            System.out.println("Remark added successfully!");
        } else {
            System.out.println("Failed to add remark.");
        }

        // Add another valid remark
        if (prescription.addRemark("This client is happy with the service.", "Optometrist")) {
            System.out.println("Second remark added successfully!");
        } else {
            System.out.println("Failed to add second remark.");
        }

        // Try adding a third remark (should fail because limit is 2)
        if (prescription.addRemark("Third remark should fail.", "Client")) {
            System.out.println("Remark added successfully!");
        } else {
            System.out.println("Failed to add third remark.");
        }
    }
}
