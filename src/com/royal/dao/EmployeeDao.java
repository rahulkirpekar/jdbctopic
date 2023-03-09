package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.royal.bean.EmployeeBean;
import com.royal.util.DbConnection;

public class EmployeeDao 
{
	public int insert(EmployeeBean ebean) 
	{
		String insertQuery = "INSERT INTO employee (name,salary,dsgn,orgName) VALUES ('"+ebean.getName()+"','"+ebean.getSalary()+"','"+ebean.getDsgn()+"','"+ebean.getOrgName()+"')";
		
		Connection conn = DbConnection.getDbConnection();
		
		Statement stmt = null;
		
		int rowAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				
				rowAffected = stmt.executeUpdate(insertQuery);
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("EmployeeDao----insert()----Db Not Connected");
		}
		return rowAffected;
	}
	public void update() 
	{

	}
	public void delete() 
	{

	}
	public ArrayList<EmployeeBean> getAllRecords() 
	{
		String selectQuery = "SELECT * FROM employee";
		Connection conn = DbConnection.getDbConnection();
		Statement stmt = null;
		ResultSet rs = null;
		EmployeeBean ebean = null;
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(selectQuery);
				
				while(rs.next()) 
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String salary = rs.getString(3);
					String dsgn = rs.getString(4);
					String orgName = rs.getString(5);
					ebean = new EmployeeBean(id, name, salary, dsgn, orgName);
					list.add(ebean);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else
		{
			System.out.println("EmployeeDao - getAllRecords() - Db not connected");
		}
		return list;
	}
	public static void main(String[] args) 
	{
//		Scanner sc  = new Scanner(System.in);
//		System.out.println("Enter Name : ");
//		String name = sc.nextLine();
//		System.out.println("Enter salary : ");
//		String salary = sc.nextLine();
//		System.out.println("Enter Dsgn : ");
//		String dsgn = sc.nextLine();
//		System.out.println("Enter Orgname : ");
//		String orgName = sc.nextLine();
//		EmployeeBean ebean = new EmployeeBean(0, name, salary, dsgn, orgName);
//		EmployeeDao dao = new EmployeeDao();
//		int rowAffected = dao.insert(ebean);
//		if (rowAffected>0) 
//		{
//			System.out.println("Employee records inserted : " + rowAffected);
//		} else 
//		{
//			System.out.println("Employee records not inserted : " + rowAffected);
//		}
		EmployeeDao dao = new EmployeeDao();

		ArrayList<EmployeeBean> list = dao.getAllRecords();
		for (int i = 0; i <list.size(); i++) 
		{
			EmployeeBean e = list.get(i);
			System.out.println(e.getId() + " " +e.getName() + " " + e.getSalary() + " " + e.getDsgn() + "  "+e.getOrgName() );
		}
	}
}