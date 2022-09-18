public class TaxManager
  {
    double FTax = 0;
    double STax = 0;
    double FiTax = 0;
    String fname;
    String lname;
    String mname = "";
    double rate;
    String address;
    String city;
    String state;
    int zip;
    String phone;
    String email;
    PayrollManager pm = new PayrollManager();
    PayPeriod period = new PayPeriod();
    Employee emp = new Employee(fname, lname, mname, rate, address, city, state, zip, phone, email);
    //Calculating taxes for an employee
    public double computeFederalTax(double grosspay, TaxPayment taxRates)
    {
      double annualGross = grosspay * 52;
      if(annualGross<=10000)
      {
        FTax = annualGross * taxRates.FederalTax1;
      }
      else if(annualGross >= 10001 && annualGross <= 25000)
      {
        FTax = annualGross * taxRates.FederalTax2;
      }
      else if(annualGross >= 25001 && annualGross <= 50000)
      {
        FTax = annualGross * taxRates.FederalTax3;
      }
      else if(annualGross > 50000)
      {
        FTax = annualGross * taxRates.FederalTax4;
      }
      return FTax/52;
    }
    //Different methods for calculating tax rates for IL and WI.
    public double computeStateTaxIL(double grosspay, TaxPayment taxRates)
    {
        STax = grosspay * taxRates.stateTaxIL;
      return STax;
    }
    public double computeStateTaxWI(double grosspay, TaxPayment taxRates)
    {
        STax = grosspay * taxRates.stateTaxWI;
      return STax;
    }
    public double computeFicaTax(double grosspay, TaxPayment taxRates)
    {
      FiTax = grosspay * taxRates.FicaTax;
      return FiTax;
    }
  }
