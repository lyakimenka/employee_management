//A class to print employee info for a manager.
public class ManagerPrinter implements IPrinter
{
  double reghours = 40;
  int id = 1;
  @Override
  public void printEmployee(Employee employee)
  {
    System.out.println("Employee Id : "+ id);
    System.out.println("Last Name: "+ employee.getLname()+"  First Name: "+
    employee.getFname()+"  Middle Initial:"+employee.getMname());
    System.out.println("Address: "+employee.getAddress()+", " +employee.getCity()+", "+employee.getState()+" "+employee.getZip());
    System.out.println("Phone: "+employee.getPhone() + " Email:"+employee.getEmail());
    System.out.println("\tHourly Rate: "+employee.getRate());
    System.out.println("\tBonus: $"+ employee.getBonus());
  }

}
