//a subclass of Employee
public class Manager extends Employee 
  {
    PayrollManager pm = new PayrollManager();
    PayPeriod period = new PayPeriod();
    private double bonus;
    
    public Manager(String fname, String lname, String mname, double rate, String address, String city, String state, int zip, String phone, String email, double bonus)
    {
      super(fname, lname, mname, rate, address, city, state, zip, phone, email);
      this.bonus = bonus;
    }
    @Override
    public double getBonus()
    {
      return bonus;
    }
    public void setBonus(double bonus)
    {
      this.bonus = bonus;
    }
    public String getTotalCompensationDescription(Employee emp, PayrollManager pm)
    {
      return String.format("%s%.2f", "Hourly Compensation: $", getRate()) + "\n"
+ String.format("%s%.2f", "Manager Bonus: $", bonus);
    }
    public IPrinter getPrinter()
    {
      return new ManagerPrinter();
    }
  }
