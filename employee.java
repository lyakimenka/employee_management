import java.util.ArrayList;

public class Employee
{
  //Declating variables
  private int id = 1;
  private String fname;
  private String lname;
  private String mname;
  private String address;
  private String city;
  private String state = "";
  private int zip;
  private String phone;
  private String email;
  private double rate = 0;
  private double bonus;
  PayPeriod period = new PayPeriod();
  public Employee(String fname, String lname, String mname, double rate, String address, String city, String state, int zip, String phone, String email)
  {
    super();
    setFname(fname);
    setLname(lname);
    setrate(rate);
    setMname(mname);
    setAddress(address);
    setCity(city);
    setState(state);
    setZip(zip);
    setPhone(phone);
    setEmail(email);
  }
  //Using setters to set values 
  public void setFname(String fname)
  {
    this.fname = fname;
  }
  public void setLname(String lname)
  {
    this.lname = lname;
  }
  public void setMname(String mname)
  {
    this.mname = mname;
  }
  public void setAddress(String address)
  {
    this.address = address;
  }
  public void setCity(String city)
  {
    this.city = city;
  }
  public void setState(String state)
  {
    this.state = state;
  }
  public void setZip(int zip)
  {
    this.zip = zip;
  }
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  //Setting rate to a to access it
  public void setrate(double a)
  {
    rate = a;
  }
  //Using getters to gather values for final output
  public double getRate()
  {
    return rate;
  }
  public String getFname()
  {
    return fname;
  }
  public String getLname()
  {
    return lname;
  }
  public String getMname()
  {
    return mname;
  }
  public String getAddress()
  {
    return address;
  }
  public String getCity()
  {
    return city;
  }
  public String getState()
  {
    return state;
  }
  public int getZip()
  {
    return zip;
  }
  public String getPhone()
  {
    return phone;
  }
  public String getEmail()
  {
    return email;
  }
  public double getGross(Employee emp, PayrollManager pm)
  {
    return pm.calculateGrossPay(emp, period);
  }
  public double getGrossPay(PayrollManager pm)
  {
    return pm.getGross();
  }
  public double getHours()
  {
    return period.getHours();
  }
  public double getRegPay(PayrollManager pm)
  {
    return pm.getRegPay();
  }
  public double getOvertime(PayrollManager pm)
  {
    return pm.getOvertime();
  }
  public double getOvertimePay(Employee employee, PayrollManager pm)
  {
    return pm.calculateOvertimePay(employee, period);
  }
  public double getBonus()
  {
    return bonus;
  }
  public String getTotalCompensationDescription(Employee emp, PayrollManager pm)
  {
    return String.format("%s%.2f", "Hourly Compensation: $", getRate());
  }
  public IPrinter getPrinter()
  {
    return new EmployeePrinter();
  }
  public String toString()
  {
    return "\n" + lname + " " + fname + " " + mname + "\n"+ address + ", " + city + ", " + state + " " + zip + "\n" + phone + ",  "+ email + "\nRate: $"+ rate;
  }
}
