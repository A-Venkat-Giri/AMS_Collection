package com.dev.app;

/**Importing all the packages necessary for the class**/
import java.util.Scanner;
import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.ValidationException;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;
import com.dev.validations.Validate;

public class App {

	public static void main(String[] args) {
		/**Exception is a type of run time error. 
		 * Exception handling is a mechanism by which we handle the exceptions as per our need at run time.
		 * We use try-catch blocks for exception handling.
		 * The main purpose is to prevent abnormal termination of the program and 
		 * to customize the exception message.**/ 
		ValidationException validationexception=new ValidationException();
		Integer count=1;
		Services s=new ServicesImpl();
		Scanner sc=new Scanner(System.in);
		/**Here we have created an object of Validate class**/
		Validate v=new Validate();
		jump2 :while(true)
		{
			System.out.println("Welcome To Asset Management System");
			System.out.println("enter your choice ");
			System.out.println("1. Admin's Page");
			System.out.println("2. Manager's Page");
			System.out.println("3. Exit from the portal");
			System.out.println("Select choices from the above options");
			Integer id=sc.nextInt();
			/**If you enter 2 then the page will be directed to manager's page**/
			if(id==2)
			{
				System.out.println("enter the user id");
				Integer userid=sc.nextInt();
				System.out.println("enter password");
				String password=sc.next();

				UserMaster um=s.loginService(userid, password);
				/**equalsIgnoreCase() is used to compare a specified string to another string,ignoring 
				   case considerations**/
				if(um.getUsertype().equalsIgnoreCase("manager"))
					System.out.println("manager");


				jump1:	while(true)
				{
					System.out.println("Welcome to Manager's page");
					System.out.println("Enter your choice");
					System.out.println("1. Add the employee");
					System.out.println("2. Raise the allocation ");
					System.out.println("3. View the status");
					System.out.println("4. Exit from manager's page");
					System.out.println("Select any one option from the above options");
					Integer choice1=sc.nextInt();
					switch(choice1)
					{
					/**This case is used for adding the employee**/
					
					case 1:Employee e=new Employee();
					System.out.println("enter employee id");
					String empid=sc.next();
					/**validations for employee id**/
					Boolean b=v.idValidation(empid);
					jump:while(!b)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							empid=sc.next();
							if(v.idValidation(empid))
							{
								break jump;
							}
						}
					}
					e.setEmpno(Integer.parseInt(empid));
					System.out.println("enter employee name");

					String name=sc.next();
					/**validations for name**/
					Boolean b1=v.idValidation(name);
					jumpvalidate:while(b1)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter name in string format");
							System.out.println("enter again");
							name=sc.next();
							if(!v.idValidation(name))
							{
								break jumpvalidate;
							}
						}
					}
					e.setEname(name);
					System.out.println("enter department Id of the employee");
					String deptid=sc.next();
					/** Validations for department id**/
					Boolean b2=v.idValidation(deptid);
					jump:while(!b2)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							deptid=sc.next();
							if(v.idValidation(deptid))
							{
								break jump;
							}
						}
					}
					e.setDeptid(Integer.parseInt(deptid));
					System.out.println("enter hiredate of the employee");
					String hiredate=sc.next();
					/**validations for hire date **/
					Boolean b3=v.dateValidation(hiredate);
					jump:while(!b3)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter in YYYY/MM/DD format");
							System.out.println("enter again");
							hiredate=sc.next();
							if(!v.idValidation(hiredate))
							{
								break jump;
							}
						}
					}
					e.setHiredate(hiredate);
					System.out.println("enter job of employee");
					String job=sc.next();
					/**validations for job**/
					Boolean b4=v.idValidation(job);
					jumpvalidate:while(b4)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter in string format");
							System.out.println("enter again");
							job=sc.next();
							if(!v.idValidation(job))
							{
								break jumpvalidate;
							}
						}
					}
					e.setJob(job);
					System.out.println("enter mgr number");
					String mgr=sc.next();

					Boolean b5=v.idValidation(mgr);
					jump:while(!b5)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							mgr=sc.next();
							if(v.idValidation(mgr))
							{
								break jump;
							}
						}
					}
					e.setMgrno(Integer.parseInt(mgr));
					System.out.println("Added Employee :"+s.addEmployeeService(e));
					break;
					
					/**This case is used for raising the asset  allocation**/
					
					case 2:AssetAllocation aa=new AssetAllocation();
					aa.setAllocationid(count);
					System.out.println("Enter Asset id ");
					String assetid=sc.next();

					Boolean b6=v.idValidation(assetid);
					jump:while(!b6)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							assetid=sc.next();
							if(v.idValidation(assetid))
							{
								break jump;
							}
						}
					}
					aa.setAssetid(Integer.parseInt(assetid));

					System.out.println("Enter employee number");
					String empno=sc.next();

					Boolean b7=v.idValidation(empno);
					jump:while(!b7)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							empno=sc.next();
							if(v.idValidation(empno))
							{
								break jump;
							}
						}
					}
					aa.setEmpno(Integer.parseInt(empno));
					System.out.println("Enter allocation date");
					String date=sc.next();
					Boolean b8=v.dateValidation(date);
					jump:while(!b8)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter in YYYY/MM/DD format");
							System.out.println("enter again");
							date=sc.next();
							if(!v.idValidation(date))
							{
								break jump;
							}
						}
					}
					aa.setAllocationdate(date);
					System.out.println("Enter release date ");
					String reldate=sc.next();
					Boolean b9=v.dateValidation(reldate);
					jump:while(!b9)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter in YYYY/MM/DD format");
							System.out.println("enter again");
							reldate=sc.next();
							if(!v.idValidation(reldate))
							{
								break jump;
							}
						}
					}
					aa.setReleasedate(reldate);
					System.out.println("Enter the quantity");
					String quantity=sc.next();

					Boolean b10=v.idValidation(quantity);
					jump:while(!b10)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							quantity=sc.next();
							if(v.idValidation(quantity))
							{
								break jump;
							}
						}
					}
					aa.setQuantity(Integer.parseInt(quantity));
					System.out.println("Raised allocation request :"+s.raiseAllocationService(aa));
					System.out.println("Randomly generated allocation id :"+aa.getAllocationid());
					count++;
					break;
					
					/**This case is used to view the status by entering the allocation id**/
					
					case 3:System.out.println("enter the allocation id");
					String allocationid=sc.next();

					Boolean b11=v.idValidation(allocationid);
					jump:while(!b11)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							allocationid=sc.next();
							if(v.idValidation(allocationid))
							{
								break jump;
							}
						}
					}
					System.out.println(s.viewStatusService(Integer.parseInt(allocationid)));
					break;
					
					/**After entering the details, this case helps to logout from the manager's page**/
					
					case 4: System.out.println("Logged Out from manager's page"); 
					break jump1;
					default:System.out.println("enter valid number");
					break;

					}

				}
			}
			
			/**If you want to go to Admin's page then press option 1**/
			
			else if(id==1)
			{
				System.out.println("enter the user id");
				Integer userid=sc.nextInt();
				System.out.println("enter password");
				String password=sc.next();

				UserMaster um=s.loginService(userid, password);
				if(um.getUsertype().equalsIgnoreCase("admin"))

					System.out.println("admin");
				jump:	while(true)
				{
					System.out.println("Welcome to Admin's page");
					System.out.println("enter your choice");
					System.out.println("1. Add the asset");
					System.out.println("2.  Remove the asset");
					System.out.println("3.  Update the asset");
					System.out.println("4.  View all asset");
					System.out.println("5.  View all allocation request");
					System.out.println("6.  Set allocation status");
					System.out.println("7.  Exit from the Admin's page");
					System.out.println("Select any one option from the above");
					Integer choice=sc.nextInt();
					switch(choice)
					{ 
					/**This case is used to add the asset**/
					
					case 1:Asset a=new Asset();
					System.out.println("enter asset id");
					String assid=sc.next();

					Boolean b=v.idValidation(assid);
					jumpadmin:while(!b)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							assid=sc.next();
							if(v.idValidation(assid))
							{
								break jumpadmin;
							}
						}
					}
					a.setAssetid(Integer.parseInt(assid));
					System.out.println(" enter asset name ");	
					String assname=sc.next();
					Boolean b1=v.idValidation(assname);
					jumpadmin:while(b1)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter in string format");
							System.out.println("enter again");
							assname=sc.next();
							if(!v.idValidation(assname))
							{
								break jumpadmin;
							}
						}
					}

					a.setAssetname(assname);
					System.out.println("enter asset des");
					a.setAssetdes(sc.next());
					System.out.println("enter asset quantity");
					String assetquantity=sc.next();

					Boolean b2=v.idValidation(assetquantity);
					jumpadmin:while(!b2)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							assetquantity=sc.next();
							if(v.idValidation(assetquantity))
							{
								break jumpadmin;
							}
						}
					}
					a.setQuantity(Integer.parseInt(assetquantity));
					System.out.println(" enter asset status ");
					String status=sc.next();
					Boolean b3=v.idValidation(status);
					jumpadmin:while(b3)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter in string format");
							System.out.println("enter again");
							status=sc.next();
							if(!v.idValidation(status))
							{
								break jumpadmin;
							}
						}
					}
					a.setStatus(status);

					System.out.println("Added asset :"+s.addAssetService(a));
					break;
					
					/**This case is used to remove the asset **/
					
					case 2:System.out.println("enter the asset id you want to remove");
					Asset a1=new Asset();
					String assid1=sc.next();

					Boolean b4=v.idValidation(assid1);
					jumpadmin:while(!b4)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							assid1=sc.next();
							if(v.idValidation(assid1))
							{
								break jumpadmin;
							}
						}
					}
					a1=s.removeAssetService(Integer.parseInt(assid1));
					System.out.println("removed asset is :"+a1);
					break;
					
					/**This case is used to update any asset which is already present**/
					
					case 3: System.out.println("enter the asset id you want to update");
					String assid2=sc.next();

					Boolean b5=v.idValidation(assid2);
					jumpadmin:while(!b5)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							assid2=sc.next();
							if(v.idValidation(assid2))
							{
								break jumpadmin;
							}
						}
					}

					System.out.println("updated asset information :"+s.updateAssetService(Integer.parseInt(assid2)));
					break;
					
					/**This case is used o view all the status**/
					
					case 4:System.out.println("assets are");
					s.getAllAssetService();
					break;
					
					/**This case is used to view all allocation request**/
					
					case 5:s.getAllAssetAllocationService();
					break;
					
					/**This case is used to set allocation status**/
					
					case 6:System.out.println("enter allocation id to set status");
					
					String allocationid=sc.next();

					Boolean b6=v.idValidation(allocationid);
					jumpadmin:while(!b6)
					{
						try {
							throw validationexception;
						}
						catch(ValidationException e1)
						{
							System.out.println("please enter number");
							System.out.println("enter again");
							allocationid=sc.next();
							if(v.idValidation(allocationid))
							{
								break jumpadmin;
							}
						}
					}
					Integer allocation_id=Integer.parseInt(allocationid);
					System.out.println("enter status");
					String statuses=sc.next();
					if(s.setStatusService(allocation_id,statuses))
					{
						System.out.println("status changed");
					}
					else
					{
						System.out.println("status not changed");
					}
					break;
					
					/**This case is used to logout from the Admin's page**/
					
					case 7:System.out.println("Logged Out from Admin's page");
					break jump;
					default:System.out.println("enter valid number");
					break;
					}
				}
			}
			else if(id==3)
			{
				System.out.println("Thank you...visit again");
				sc.close();
				break jump2;
			}

		}

	}

}

