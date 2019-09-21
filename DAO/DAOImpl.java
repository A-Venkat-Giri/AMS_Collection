package com.dev.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.AddAssetException;
import com.dev.exceptions.AddEmployeeException;
import com.dev.exceptions.AllAssetAllocationException;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.RaiseAllocationException;
import com.dev.exceptions.RemoveAssetException;
import com.dev.exceptions.UpdateAssetException;
import com.dev.exceptions.ValidationException;
import com.dev.repo.Database;
import com.dev.validations.Validate;

public class DAOImpl implements DAO {
	Database db=new Database();
	Validate v=new Validate();
	Scanner sc=new Scanner(System.in);
		@Override
		/**This function is used for login purpose**/
	public UserMaster login(Integer userid, String password) {
			if(db.map.containsKey(userid))
		{
			UserMaster um=db.map.get(userid);
			if(um.getUserpassword().equals(password))
			{
				return um;
			}
		}
		else
		{
			System.out.println("enter correct username and password");

		}

		throw new LoginException();
	}

	@Override
	/**This function is used for adding the asset**/

	public Asset addAsset(Asset asset) {

		if(!db.mapa.containsKey(asset.getAssetid()))
		{
			db.mapa.put(asset.getAssetid(), asset);	
			return asset;
		}
		else
		{
			System.out.println("asset id already present");
			throw new AddAssetException();
		}
	}

	@Override
	/**This function is used for removing the asset**/

	public Asset removeAsset(Integer aid) {
		Asset a=new Asset();
		if(db.mapa.containsKey(aid))
		{
			a=db.mapa.remove(aid);
			return a;
		}
		else
		{
			throw new RemoveAssetException();
		}

	}

	@Override
	/**This function is used for removing the asset**/

	public Asset updateAsset(Integer aid) {


		if(db.mapa.containsKey(aid))
		{
			System.out.println("1.Update the asset name");
			System.out.println("2. Update the asset description");
			System.out.println("3. Update the asset quantity");
			System.out.println("4. Update the asset status");
			Integer choice=sc.nextInt();
			switch(choice)
			{
			case 1:Asset s = db.mapa.get(aid);
			System.out.println("enter the name you want to update");
			s.setAssetname(sc.next());
			return s;

			case 2:Asset s1 = db.mapa.get(aid);
			System.out.println("enter the description you want to update");
			s1.setAssetdes(sc.next());
			return s1;

			case 3:Asset s2 = db.mapa.get(aid);
			System.out.println("enter the quantity you want to update");
			s2.setQuantity(sc.nextInt());
			return s2;

			case 4: Asset s3 = db.mapa.get(aid);
			System.out.println("enter the status you want to update");
			s3.setStatus(sc.next());
			return s3;

			}
			throw new UpdateAssetException();
		}
		else
		{
			throw new UpdateAssetException();
		}
		
	}

	@Override
	/**This function is used to view all the asset present in the system**/
	public List<Asset> getAllAsset() {
		if(!db.mapa.isEmpty())
		{
			List<Asset>l=new ArrayList(db.mapa.values());
			Iterator<Asset> it=l.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}


			return l;
		}
		else {
			System.out.println("no assets are present");
			return null;
		}
	}

	@Override
	/**This function is used for adding the employee**/

	public Employee addEmployee(Employee employee) {
		if(!db.mape.containsKey(employee.getEmpno()))
		{
			db.mape.put(employee.getEmpno(), employee);
			return employee;
		}
		else
		{
			System.out.println("employee is already present");
			throw new AddEmployeeException();
		}
	}

	@Override
	
	/**This function is used to raise the asset**/
	
	public AssetAllocation raiseAllocation(AssetAllocation assetallocation) {
		if(!db.mapas.containsKey(assetallocation.getAllocationid()))
		{
			db.mapas.put(assetallocation.getAllocationid(), "null");
			if(!db.mapaa.containsKey(assetallocation.getAllocationid()))
			{
				db.mapaa.put(assetallocation.getAllocationid(), assetallocation);
				return assetallocation;
			}
		}
		else
		{
			throw new RaiseAllocationException();
		}
		throw new RaiseAllocationException();
	}

	@Override
	public List<AssetAllocation> getAllAssetAllocation() {
		if(!db.mapaa.isEmpty())
		{
			List<AssetAllocation>ll=new ArrayList(db.mapaa.values());
			Iterator <AssetAllocation>it=ll.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next()); 
			}
			return ll;

		}
		else
		{
			System.out.println("Raise list is not available");
			throw new AllAssetAllocationException();
		}
	}

	@Override
	/**This function is used to set the status of the status**/
	public Boolean setStatus(Integer allocationid,String status) {
		if(db.mapaa.containsKey(allocationid))
		{
			Boolean b1=v.idValidation(status);
			jumpvalidate:while(b1)
			{
				try {
					throw new ValidationException();
				}
				catch(ValidationException e1)
				{
					System.out.println("please enter in string format");
					System.out.println("enter again");
					status=sc.next();
					if(!v.idValidation(status))
					{
						break jumpvalidate;
					}
				}
			}

			db.mapas.put(allocationid,status);
			return true;

		}
		else
		{
			return false;
		}
	}

	@Override
	/**This function is used to view the status by entering the allocation id**/
	public String viewStatus(Integer allocationid) {
		if(db.mapas.containsKey(allocationid))
		{

			String s=db.mapas.get(allocationid);
			if(!s.isEmpty())
			{
				return s;
			}
			else
			{
				return "status not available";
			}

		}
		else
		{
			return "Status not available";

		}
	}
}
