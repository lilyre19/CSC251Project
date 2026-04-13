import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo 
{   
   public static void main(String[] args) throws IOException
   {
      // Create file object
      File file = new File("PolicyInformation.txt");
      Scanner input = new Scanner(file);

      // ArrayList to store policies
      ArrayList<Policy> policies = new ArrayList<>();

      // Read file
      while (input.hasNext())
      {
         String policyNumber = input.nextLine();
         String providerName = input.nextLine();
         String firstName = input.nextLine();
         String lastName = input.nextLine();
         int age = input.nextInt();
         input.nextLine(); // clear buffer
         String smokingStatus = input.nextLine();
         double height = input.nextDouble();
         double weight = input.nextDouble();
         input.nextLine(); // clear buffer

         // Create object
         Policy policy = new Policy(policyNumber, providerName, firstName,
                                    lastName, age, smokingStatus, height, weight);

         policies.add(policy);
      }

      input.close();

      // Counters
      int smokers = 0;
      int nonSmokers = 0;

      // Display all policies
      for (Policy policy : policies)
      {
         System.out.println("Policy Number: " + policy.getPolicyNumber());
         System.out.println("Provider Name: " + policy.getProviderName());
         System.out.println("Policyholder's First Name: " + policy.getFirstName());
         System.out.println("Policyholder's Last Name: " + policy.getLastName());
         System.out.println("Policyholder's Age: " + policy.getAge());
         System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
         System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
         System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
         System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
         System.out.printf("Policy Price: $%.2f\n\n", policy.getPrice());

         // Count smokers
         if (policy.getSmokingStatus().equalsIgnoreCase("smoker"))
            smokers++;
         else
            nonSmokers++;
      }

      // Final output
      System.out.println("The number of policies with a smoker is: " + smokers);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
   }
}
