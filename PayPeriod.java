public class PayPeriod 
{
  //Declating variables
  private int payId = 1;
  private int id;
  private String startDate;
  private String endDate;
  private double hours;

  //Setting values
  public void setData(int payId, int id, String startDate, String endDate, double hours)
  {
    this.payId = payId;
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.hours = hours;
  }
//Getting hours
   public double getHours()
  {
    return hours;
  }
  
  TaxPayment taxRates = new TaxPayment();
}
