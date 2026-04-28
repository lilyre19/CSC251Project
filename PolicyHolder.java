public class PolicyHolder
{
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // Constructor
    public PolicyHolder(String fName, String lName, int age, String smoking,
                        double height, double weight)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.smokingStatus = smoking;
        this.height = height;
        this.weight = weight;
    }

    // Copy constructor (IMPORTANT for security - Step 5)
    public PolicyHolder(PolicyHolder obj)
    {
        this.firstName = obj.firstName;
        this.lastName = obj.lastName;
        this.age = obj.age;
        this.smokingStatus = obj.smokingStatus;
        this.height = obj.height;
        this.weight = obj.weight;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    // BMI method
    public double getBMI()
    {
        return (weight * 703) / (height * height);
    }

    // toString (Step 2)
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
