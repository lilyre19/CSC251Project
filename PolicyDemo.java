import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo 
{   
   public static void main(String[] args) throws IOException
   {
      File file = new File("PolicyInformation.txt");
      Scanner input = new Scanner(file);

      ArrayList<Policy> policies = new ArrayList<>();

      while (input.hasNext())
      {
         String policyNumber = input.nextLine();
         String providerName = input.nextLine();
         String firstName = input.nextLine();
         String lastName = input.nextLine();
         int age = input.nextInt();
         input.nextLine();
         String smokingStatus = input.nextLine();
         double height = input.nextDouble();
         double weight = input.nextDouble();
         input.nextLine();

         // CREATE PolicyHolder first
         PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                smokingStatus, height, weight);

         // PASS it into Policy
         Policy policy = new Policy(policyNumber, providerName, holder);

         policies.add(policy);
      }

      input.close();

      int smokers = 0;
      int nonSmokers = 0;

      for (Policy policy : policies)
      {
         System.out.println(policy); // implicit toString
         System.out.println();

         if (policy.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker"))
            smokers++;
         else
            nonSmokers++;
      }

      System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
      System.out.println("The number of policies with a smoker is: " + smokers);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
   }
}
