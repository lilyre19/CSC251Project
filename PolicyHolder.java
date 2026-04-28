public class PolicyHolder
{
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   // Constructor
   public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w)
   {
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }

   // Copy constructor (SECURITY requirement)
   public PolicyHolder(PolicyHolder obj)
   {
      firstName = obj.firstName;
      lastName = obj.lastName;
      age = obj.age;
      smokingStatus = obj.smokingStatus;
      height = obj.height;
      weight = obj.weight;
   }

   // Getters
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public int getAge() { return age; }
   public String getSmokingStatus() { return smokingStatus; }
   public double getHeight() { return height; }
   public double getWeight() { return weight; }

   // BMI
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      return (weight * CONVFACTOR) / (height * height);
   }

   // toString
   public String toString()
   {
      return "Policyholder's First Name: " + firstName +
             "\nPolicyholder's Last Name: " + lastName +
             "\nPolicyholder's Age: " + age +
             "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus +
             "\nPolicyholder's Height: " + height + " inches" +
             "\nPolicyholder's Weight: " + weight + " pounds" +
             "\nPolicyholder's BMI: " + String.format("%.2f", getBMI());
   }
}
