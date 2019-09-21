package com.dev.repo;

import java.util.HashMap;
import java.util.Map;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.AssetStatus;
import com.dev.beans.Department;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public class Database {
	public Map<Integer,UserMaster> map;
	public Map<Integer,Employee> mape;
	public Map<Integer,Department> mapd;
	public Map<Integer,Asset> mapa;
	public Map<Integer,AssetAllocation> mapaa;
	public Map<Integer,String> mapas;

	public Database() {
		map = new HashMap<Integer,UserMaster>();
		/**Creating the object of the usermaster class**/
		UserMaster um=new UserMaster();
		/**Setting up the UserId**/
		um.setUserid(1);
		/**Setting up the UserName**/
		um.setUsername("Venkat");
		/**Setting up the UserPaaword**/
		um.setUserpassword("root");
		um.setUsertype("manager");
		map.put(um.getUserid(), um);

		UserMaster um1=new UserMaster();
		um1.setUserid(2);
		um1.setUsername("Giri");
		um1.setUserpassword("root");
		um1.setUsertype("admin");
		map.put(um1.getUserid(), um1);	

		mape = new HashMap<Integer,Employee>();
		/**Creating the object of Employee class**/
		Employee e=new Employee();
		e.setEmpno(101);
		e.setEname("venkat");
		e.setDeptid(25);
		e.setHiredate("24-10-2018");
		e.setJob("Full Stack Developer");
		e.setMgrno(18);
		mape.put(e.getEmpno(),e);

		mapd = new HashMap<Integer,Department>();
		/**Creating the object of Department class**/
		Department d=new Department();
		d.setDeptid(25);
		d.setDeptname("Development Department");
		mapd.put(d.getDeptid(), d);

		mapa = new HashMap<Integer,Asset>();
		/**Creating the object of Asset class**/
		Asset a=new Asset();
		a.setAssetid(500);
		a.setAssetname("Laptop");
		a.setAssetdes("Classy");
		a.setQuantity(1);
		a.setStatus("present");
		mapa.put(a.getAssetid(),a);

		mapaa = new HashMap<Integer,AssetAllocation>();
		/**Creating the object of Asset
		 * 
		 * Allocation class**/
		AssetAllocation all=new AssetAllocation();
		all.setAllocationid(1000);
		all.setAssetid(500);
		all.setEmpno(100);
		all.setAllocationdate("30-11-2019");
		all.setReleasedate("12-12-2019");
		all.setQuantity(20);
		mapaa.put(all.getAllocationid(), all);

		mapas=new HashMap<Integer,String>();
		/**Creating the object of AssetStatus class **/
		AssetStatus as=new AssetStatus();
		as.setAllocationid(1000);
		as.setStatus("");
		mapas.put(as.getAllocationid(), as.getStatus());
	}
}
