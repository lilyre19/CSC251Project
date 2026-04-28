public class Policy
{
   private String policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;

   private static int policyCount = 0;

   // Constructor
   public Policy(String pNumber, String pName, PolicyHolder holder)
   {
      policyNumber = pNumber;
      providerName = pName;
      policyHolder = new PolicyHolder(holder); // copy for security
      policyCount++;
   }

   // Getters
   public String getPolicyNumber()
   {
      return policyNumber;
   }

   public String getProviderName()
   {
      return providerName;
   }

   public PolicyHolder getPolicyHolder()
   {
      return new PolicyHolder(policyHolder); // return copy
   }

   public static int getPolicyCount()
   {
      return policyCount;
   }

   // Price calculation
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;

      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;

      double price = BASE_PRICE;

      if(policyHolder.getAge() > AGE_THRESHOLD)
         price += ADDITIONAL_FEE_AGE;

      if(policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
         price += ADDITIONAL_FEE_SMOKING;

      if(policyHolder.getBMI() > BMI_THRESHOLD)
         price += ((policyHolder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

      return price;
   }

   // toString (IMPORTANT)
   public String toString()
   {
      return "Policy Number: " + policyNumber +
             "\nProvider Name: " + providerName + "\n" +
             policyHolder.toString() +
             "\nPolicy Price: $" + String.format("%.2f", getPrice());
   }
}
