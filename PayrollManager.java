import java.util.ArrayList;
import java.util.List;
public class PayrollManager
{
  double grosspay = 0;
  double regpay;
  double overtime;
  double overtimePay;
  double reghours = 40;
  double netPay;
  double getpercent = 0;
  double getFTax = 0;
  double getSTax = 0;
  double getFicaTax = 0;
  double getNet = 0;
  double annualGrossPay = 0;
  String fname;
  String lname;
  String state;
  List<Employee> employees = new ArrayList<>();
  //Employee emp = new Employee(fname, lname);
  //A method to calculate regpay
  public double calculateRegularPay(Employee emp, PayPeriod period)
  {
    regpay = emp.getRate() * reghours;
    return regpay;
  }
  public double getRegPay()
  {
    return regpay;
  }
  //A method to calculate overtime hours
  public double calculateOvertime(Employee emp, PayPeriod period)
  {
    overtime = period.getHours() - 40;
    return overtime;
  }
  public double getOvertime()
  {
    return overtime;
  }
  //A method to calculate overtimePay
  public double calculateOvertimePay(Employee employee, PayPeriod period)
  {
    overtimePay = overtime * 15;
    return overtimePay;
  }
  public double getOvertimePay()
  {
    return overtimePay;
  }
  //A method to calculate grosspay
  public double calculateGrossPay(Employee emp, PayPeriod period)
  {
    if(period.getHours()<=40)
    {
      grosspay =  emp.getRate()*period.getHours();
      return grosspay;
    }
    else if(period.getHours()>40)
    {
      grosspay = overtimePay + regpay;
      return grosspay;
    }
    return grosspay;
  }
  public double getGross()
  {
    return grosspay;
  }
  public double annualGross(Employee emp, PayPeriod period)
  {
    annualGrossPay = grosspay * 52;
    return annualGrossPay;
  }
  //Calculating Net pay
  public double getNetPay(Employee emp, PayPeriod period, double grosspay, TaxPayment taxRates, TaxManager tax)
  {
    netPay = calculateGrossPay(emp, period) - tax.computeFederalTax(grosspay, taxRates)-getSTax-tax.computeFicaTax(grosspay, taxRates);
    return netPay;
  }
  
  //A method to pring out pay info
   public void printPayStub(Employee employee, PayPeriod period, TaxManager tax, TaxPayment taxRates)
   {
     String getstate = employee.getState();
     System.out.println("-----------------------------------------------------------");
       //double grossPay = period.getHours();
     if(period.getHours()<=40)
     {
       //Using printf to be able to format integer output
       System.out.printf("Hours Worked: "+period.getHours()+"  Hourly Rate: $%3.2f%n",employee.getRate());
       System.out.printf("Gross Total: $%3.2f%n", calculateGrossPay(employee, period));
       System.out.println("-----------------------------------------------------------");
       System.out.println("Taxes: \nState:"+getstate);
       if(getstate.equals("IL")||getstate.equals("il"))
       {
         System.out.println("IL:"+getstate);
       }
       else if(getstate.equals("WI")||getstate.equals("wi"))
       {
         System.out.println("WI:"+getstate);
       }
       System.out.printf("Federal Tax:$%3.2f%n", tax.computeFederalTax(grosspay, taxRates));
    if(getstate.equals("IL")||getstate.equals("il"))
    {
      System.out.printf("State Tax:$%3.2f%n", tax.computeStateTaxIL(grosspay, taxRates));
    }
    else if(getstate.equals("WI")||getstate.equals("wi"))
    {
     System.out.printf("State Tax:$%3.2f%n", tax.computeStateTaxWI(grosspay, taxRates));
    }
       //System.out.printf("State Tax:$%3.2f%n", getSTax);
       System.out.printf("FicaTax:$%3.2f%n", tax.computeFicaTax(grosspay, taxRates));
       System.out.println("-----------------------------------------------------------");
       System.out.printf("Net Paycheck: $%3.2f%n", getNetPay(employee, period, grosspay, taxRates, tax));
     }
     else if(period.getHours()>40)
     {
       System.out.printf("Hours Worked: "+period.getHours());
       System.out.printf(" Regular Pay: "+reghours+" hours at $%3.2f", employee.getRate());
       System.out.printf("/hr: $%3.2f", calculateRegularPay(employee, period));
       System.out.printf("\nOvertime Pay: "+calculateOvertime(employee, period)+" hours at $15.00/hr: $%3.2f", calculateOvertimePay(employee, period));
       System.out.printf("\nGross Total: $%3.2f%n", calculateGrossPay(employee, period));
       System.out.println("\n-----------------------------------------------------------");
        System.out.println("Taxes: \nState:"+getstate);
       if(getstate.equals("IL")||getstate.equals("il"))
       {
         System.out.println("IL:"+getstate);
       }
       else if(getstate.equals("WI")||getstate.equals("wi"))
       {
         System.out.println("WI:"+getstate);
       }
       System.out.printf("Federal Tax:$%3.2f%n", tax.computeFederalTax(grosspay, taxRates));
       //Need an if statement to determine state for state tax.
    if(getstate.equals("IL")||getstate.equals("il"))
    {
      System.out.printf("State Tax:$%3.2f%n", tax.computeStateTaxIL(grosspay, taxRates));
    }
    else if(getstate.equals("WI")||getstate.equals("wi"))
    {
     System.out.printf("State Tax:$%3.2f%n", tax.computeStateTaxWI(grosspay, taxRates));
    }
       System.out.printf("FicaTax: $%3.2f%n", tax.computeFicaTax(grosspay, taxRates));
       System.out.println("-----------------------------------------------------------");
       System.out.printf("Net Paycheck: $%.2f%n",getNetPay(employee, period, grosspay, taxRates, tax));
     }
     }
  //System.out.println("State: " + getstate);
  public double getfTax(TaxManager tax, TaxPayment taxRates)
  {
    return getFTax = tax.computeFederalTax(grosspay, taxRates);
  }
  public double getsTax(Employee emp, PayPeriod period, TaxManager tax, TaxPayment taxRates)
  {
    String getstate = emp.getState();
    if(getstate.equals("IL")||getstate.equals("il"))
    {
      getSTax = tax.computeStateTaxIL(grosspay, taxRates);
    }
    else if(getstate.equals("WI")||getstate.equals("wi"))
    {
      getSTax = tax.computeStateTaxWI(grosspay, taxRates);
    }
    return getSTax;
  }
  public double getficaTax(TaxManager tax, TaxPayment taxRates)
  {
    return getFicaTax = tax.computeFicaTax(grosspay, taxRates);
  }
  public double getNetpay(Employee emp, PayPeriod period, TaxPayment taxRates, TaxManager tax)
  {
    return getNet = getNetPay(emp, period, grosspay, taxRates, tax);
  }
   }

