package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.collections4.map.HashedMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		 Connection conn1 = null;
	        Connection conn2 = null;
	        Connection conn3 = null;
	 
	        try {
	            // registers Oracle JDBC driver - though this is no longer required
	            // since JDBC 4.0, but added here for backward compatibility
	            Class.forName("oracle.jdbc.OracleDriver");
	 
/*	            // METHOD #1
	            String dbURL1 = "jdbc:oracle:thin:hr/hr@localhost:1521:orclpdb";
	            conn1 = DriverManager.getConnection(dbURL1);
	            if (conn1 != null) {
	                System.out.println("Connected with connection #1");
	            }
	 */
	            // METHOD #2
	            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:orcl";//select sys_context('userenv','instance_name') from dual;
//orcl
	            String username = "system";
	            String password = "oracle";
	            conn2 = DriverManager.getConnection(dbURL2, username, password);
	            if (conn2 != null) {
	                System.out.println("Connected with connection #2");
	            }
	            
	            JasperReport jasperReport =null;
				try {
					jasperReport = (JasperReport) JRLoader.loadObjectFromFile("test.jasper");
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          //  Map<String, Object> parameters = new HashMap<String, Object>();
	            JasperPrint jasperPrint = null;
				try {
					jasperPrint = JasperFillManager.fillReport(jasperReport, new HashedMap<String, Object>(), conn2);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            try {
					JasperExportManager.exportReportToPdfFile(jasperPrint, "MyJasperReport.pdf");
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            

	            
	            
	            
	            
	            
	            
	            
/*	          //step3 create the statement object  
	            Statement stmt=conn2.createStatement();  
	              
	            //step4 execute query  
	            ResultSet rs=stmt.executeQuery("SELECT EMPLOYEE_ID,FIRST_NAME,JOB_ID FROM EMPLOYEES");
	            List<Employee> emplist = new ArrayList<Employee>();
	            while (rs.next()) {
	            	emplist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3)));
	            }

	            	
	            Map<Object, List<Employee>> map =
	            		emplist.stream().collect(Collectors.groupingBy(w -> w.getJob_id()));

	            
	            System.out.println(map.toString());
	            
	            Set<Object> groupedEmpSet = map.keySet();
	            for (Object jobid: groupedEmpSet) {
	            	System.out.println(jobid);
	               List<Employee> emplistnew = map.get(jobid);
	               for (Employee emp : emplistnew) {
	                    System.out.println("ID : "+emp.getEmp_id()+"\t"+"Name : "+emp.getEmp_name()+"\t"+"Jobid : "+emp.getJob_id());
	                }
	            }*/
	            
	            
	 
	            // METHOD #3
	           /* String dbURL3 = "jdbc:oracle:oci:@orclpdb";
	            Properties properties = new Properties();
	            properties.put("user", "hr");
	            properties.put("password", "hr");
	            properties.put("defaultRowPrefetch", "20");
	            conn3 = DriverManager.getConnection(dbURL3, properties);
	 
	            if (conn3 != null) {
	                System.out.println("Connected with connection #3");
	            }*/
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (conn1 != null && !conn1.isClosed()) {
	                    conn1.close();
	                }
	                if (conn2 != null && !conn2.isClosed()) {
	                    conn2.close();
	                }
	                if (conn3 != null && !conn3.isClosed()) {
	                    conn3.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        }

	}


