import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
class Main 
{
  public static void main(String[] args) throws Exception  
  {
    //Initializing ArrayList
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Double> payPeriod = new ArrayList<Double>();
    payPeriod = new ArrayList<Double>(payPeriod);
    //Declaring all the variables needed
    String answer;
    int id = 1;
    String fname = "";
    String lname = "";
    String mname = "";
    String address = "";
    String city = "";
    String state = "";
    int zip = 0;
    String phone = "";
    String email = "";
    double rate = 0;
    double hours;
    int payId = 1;
    String startDate = "";
    String endDate = "";
    int count = 0;
    double totalGrossPay = 0;
    double getGrossPay;
    double averageGrossPay; 
    double getTotalHours = 0;
    double getOvertimeHours = 0;
    double getOvertimePaid = 0;
    double getSTax = 0;
    double getFicaTax = 0;
    double getPercent = 0;
    double getFTax = 0;
    String getstate;
    PayrollManager pm = new PayrollManager();
    Employee emp = new Employee(fname, lname, mname, rate, address, city, state, zip, phone, email);
    //Using a do-while loop so the user can enter data multiple times
    do{
      //Initializing emp object
      //Employee emp = new Employee(fname, lname);
      Scanner input = new Scanner(System.in);
      //Collecting data from the user
      System.out.print("Enter Employee first name:");
        fname = input.nextLine();
      emp.setFname(fname);
      System.out.print("Enter Employee last name:");
        lname = input.nextLine();
      emp.setLname(lname);
      System.out.print("Enter Employee middle initial:");
        mname = input.nextLine();
      emp.setMname(mname);
      System.out.print("Enter address:");
        address = input.nextLine();
      emp.setAddress(address);
      System.out.print("Enter city:");
        city = input.nextLine();
      emp.setCity(city);
      System.out.print("Enter state:");
        state = input.nextLine();
      emp.setState(state);
      System.out.print("Enter zipcode:");
        zip = Integer.parseInt(input.nextLine());
      emp.setZip(zip);
      System.out.print("Enter email:");
        email = input.nextLine();
      emp.setEmail(email);
      System.out.print("Enter phone:");
        phone = input.nextLine();
      emp.setPhone(phone);
      System.out.print("Enter hourly rate of pay:");
        rate = input.nextDouble();
      emp.setrate(rate);
      System.out.print("Is this a manager? (Y/N):");
      char type = input.next().toUpperCase().charAt(0);
      if (type == 'N') 
      {
        employees.add(new Employee(fname, lname, mname, rate, address, city, state, zip, phone, email));
      } 
      else
      {
        System.out.print("Manager Bonus amount:");
        double bonus = input.nextDouble();
        employees.add(new Manager(fname, lname, mname, rate, address, city, state, zip, phone, email, bonus));
      }
      //Writing array list info into a txt file
    
      
      //while (myReader.hasNextLine()) {
        //String data = myReader.nextLine();
        //System.out.println(data);
      //}
      //myReader.close();
      //Initializing period object
      PayPeriod period = new PayPeriod();
      //Collecting additional data
      System.out.print("Enter # of hours worked this week:");
        hours = input.nextDouble();
      //employees.add(emp);
      //Setting data in PayPeriod
      period.setData(payId, id, startDate, endDate, hours);
      //Initializing more objects
      TaxManager tax = new TaxManager();
      TaxPayment taxRates = new TaxPayment();
      System.out.println("\n-----------------------------------------------------------");
      for (Employee e : employees) 
      {
        e.getPrinter().printEmployee(e);
      }
      
      //Calling printPayStub to print payout info
      pm.printPayStub(emp, period, tax, taxRates);
      //Asking user is they want to enter more data
      System.out.print("\nWould you like to enter another employee? (Y/N)");
      //Getting user's answer
      answer = input.next();
      //A counter to count loops
      count++;
      //Getting all the values for Summary Report
      getGrossPay = pm.calculateGrossPay(emp, period);
      payPeriod.add(getGrossPay);
      totalGrossPay = totalGrossPay + pm.calculateGrossPay(emp, period);
      getTotalHours = getTotalHours + period.getHours();
      getOvertimeHours = getOvertimeHours + pm.calculateOvertime(emp, period);
      getOvertimePaid = getOvertimePaid + pm.calculateOvertimePay(emp, period);
      getFTax = getFTax + pm.getfTax(tax, taxRates);
      getSTax = getSTax + pm.getsTax(emp, period, tax, taxRates);
      getFicaTax = getFicaTax + pm.getficaTax(tax, taxRates);
      getPercent = (pm.getNetpay(emp, period, taxRates, tax) / totalGrossPay)*100;
      getPercent = Math.round(getPercent*100)/100;
      getstate = emp.getState();
      
      //If the condition is met - enter another employee
    }while("Y".equals(answer)||"y".equals(answer));
    System.out.println("\nEmployee List\n-----------------------------------------------------------");
    //Using counter to count lines when printing list
    int counter = 1;
		//Displaying an employee list using for loop
    for(Employee e : employees)
      {
          System.out.println(counter++ + "\t\t" + e.getLname() + ", " + e.getFname());
          System.out.println("Compensation: "+e.getTotalCompensationDescription(emp, pm));
      }
    
     System.out.println("-----------------------------------------------------------");
    //Displaying Summary Report
    
    System.out.println("Summary Report\n--------------------------------------------------------");
    //Displaying Summary Report
    System.out.println("State:"+getstate);
    if(getstate.equals("IL")||getstate.equals("il"))
       {
         System.out.println("IL:"+getstate);
       }
       else if(getstate.equals("WI")||getstate.equals("wi"))
       {
         System.out.println("WI:"+getstate);
       }
      System.out.println("Employees Entered:"+ count);
      System.out.printf("Total Gross Pay:$%3.2f%n", totalGrossPay);
    double largest = payPeriod.get(0);
    double smallest = payPeriod.get(0);
    //Need a for loop to search for largest/smallest value in an arraylist
    for (int i = 1; i<payPeriod.size(); i++)
      {
        if(payPeriod.get(i)>largest)
        {
          largest = payPeriod.get(i);
        }
      }
    for (int i = 1; i<payPeriod.size(); i++)
      {
        if(payPeriod.get(i)<smallest)
        {
          smallest = payPeriod.get(i);
        }
      }
    System.out.printf("Highest Gross Pay:$%3.2f%n", largest);
    System.out.printf("Lowest Gross Pay:$%3.2f%n", smallest);
    averageGrossPay = totalGrossPay / payPeriod.size();
    System.out.printf("Average Gross Pay:$%3.2f%n", averageGrossPay);
    System.out.printf("Total number of hours:%.0f", getTotalHours);
    System.out.printf("\nTotal number of overtime hours:%.0f", getOvertimeHours);
    System.out.printf("\nTotal overtime paid:$%3.2f%n", getOvertimePaid);
    System.out.println("Overtime % of total Gross:"+ String.format("%.2f",getPercent)+" %");
    System.out.printf("Federal Tax Total:$%3.2f%n", getFTax);
    System.out.printf("State Tax Total:$%3.2f%n", getSTax);
    System.out.printf("Fica Tax Total:$%3.2f%n", getFicaTax);
    System.out.println("-----------------------");
    //Using try catch exception
    try {
      //Declaring a file name to look for
      File myFile = new File ("employees.txt");
     if(myFile.exists())
     {
       myFile.delete();
     }
      FileWriter fw = new FileWriter(myFile);
      BufferedWriter bw = new BufferedWriter(fw);
      //If the file already exists - delete it
      //if(myFile.exists())
     // {
       // myFile.delete();
      //}
      bw.write(employees.toString());
      bw.close();
      System.out.println("Employee(s) Saved");
    }
    catch (IOException ioe) 
      {
        ioe.printStackTrace();
      }
  }
}
