package sqlproject2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class exam {
		public static void main(String[] args) {
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String id = "c##hr";
			String pw = "hr";
			Scanner sc = new Scanner(System.in);
			Connection conn = null;
			PreparedStatement ps = null;
			Statement stat = null;
			ResultSet rs = null;
	
			
			try {
			System.out.println("����̹� �ε���...\n\n");
			System.out.println("-----------------------");
			System.out.println("|�����ͺ��̽��� �����߽��ϴ�.|");
			System.out.println("-----------------------\n\n");
			
			
//			System.out.printf("�̸� %s", rs.getString(1));
			
			 Scanner scan= new Scanner(System.in);
		        System.out.print("�˻��ϰ� ���� ��� �̸��� �Է��ϼ���>>");
		        String name =scan.nextLine();
		       

		    Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT first_name||' '||last_name, to_char(hire_date, 'yyyy\"�� \"mm\"�� \"dd\"�� \"'), to_char(hire_date, 'yyyy'),salary, 12*salary from employees "
	    			+ "where first_name= ?" + "order by hire_date";
				
			ps = conn.prepareStatement(sql);
	    	ps.setString(1, name);
	    	stat = conn.createStatement();
	    	rs = ps.executeQuery();

			while(rs.next()) {
				try {
				double ss5 =rs.getInt(5);
				int cw = 2008-rs.getInt(3);
				double rate = 0.03;
		

				boolean result = true;
				System.out.printf("�̸� %s, �Ի��� %s, ���� %s, ���� %s", rs.getString(1), rs.getString(2), rs.getInt(4),rs.getInt(5));
				for(int i =0; i<=cw; i++) {
					ss5 = ss5+(ss5*rate); 
					if(cw == 0) {
						System.out.printf("\n���� ���� %s\n", rs.getInt(5));
						result = false;
						break;
					}else if (i >= 1) {
					}else if(i==cw) {
						break;
					}
				}
				if (result) {
					System.out.printf("\n�λ�� ���� %s\n", Math.round(ss5*100)/100.0);	
				}
				
				}catch (Exception e) {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ��Է����ּ���.");
				}
			}
			}
			catch (Exception e) {			
				System.out.println(e.getMessage());		}	
	    	
			    finally {
				    	try {
							rs.close();
							ps.close();
							conn.close();
				    	} catch(Exception e) {
				    		System.out.println(e.getMessage());
				    	}
				}
			}
}	
	
	
	
			
//			
//			rs = stat.executeQuery
//			("SELECT first_name||' '||last_name as Name, to_char(hire_date, 'yyyy\"�� \"mm\"�� \"dd\"�� \"') as Hire, to_char(hire_date, 'yyyy'), salary, 12*salary from employees order by hire_date");
//			while(rs.next()) {
//				String ss1 = rs.getString(1);
//				String ss2 = rs.getString(2);
//				int ss3 = rs.getInt(3);
//				double ss4 =rs.getInt(4);
//				double ss5 =rs.getInt(5);
//				int cw = 2008-ss3;
//				double rate = 0.03;
//				double salary = ss5;
//				boolean result = true;
//				
//				System.out.printf("�̸� %s, �Ի��� %s, ���� %s, ���� %s", ss1 ,ss2 ,ss4 ,ss5);
//				for(int i =0; i<=cw; i++) {
//					salary = salary+(salary*rate); 
//					if(cw == 0) {
//						System.out.printf("\n���� ���� %s\n", ss5);
//						result = false;
//						break;
//					}else if (i >= 1) {
//					}else if(i==cw) {
//						break;
//					}
//				}
//				if (result) {
//					System.out.printf("\n�λ�� ���� %s\n", Math.round(salary*100)/100.0);	
//				}
				
				
//				 PreparedStatement pstmt = null;                   
//				 System.out.println("�˻��ϰ� ���� ��� �̸��� �Է��ϼ���>>");         
//				 String searchname = sc.nextLine();
//				
//				 String sqlSelect = "select first_name||' '||last_name as Name employees";                  
//				 pstmt = conn.prepareStatement(sqlSelect);         
//				 pstmt.setString(1, searchname);                  
//				 ResultSet rs1 = pstmt.executeQuery();
//			
//				 if (rs1.equals(searchname)) {
//					 System.out.println("�˻� ��� X");
//				 }else {
//					 System.out.printf("�̸� %s, �Ի��� %s, ���� %s, ���� %s, \\n�λ�� ���� %s\\n", ss1 ,ss2 ,ss4 ,ss5 ,Math.round(salary*100)/100.0);
//				 }

//		public static void Serach(Scanner scan, Statement stat) {
//			System.out.println("�˻��ϰ� ���� ��� �̸��� �Է��ϼ���>>");         
//			String searchname = sc.nextLine();
//			ResultSet rs = null;
//			try {
//	            rs = stat.executeQuery("SELECT first_name||' '||last_name as Name, to_char(hire_date, 'yyyy\\\"�� \\\"mm\\\"�� \\\"dd\\\"�� \\\"') as Hire, to_char(hire_date, 'yyyy'), salary, 12*salary from employees order by hire_date");
//	            rs.next();
//	            System.out.printf("�̸� %s, �Ի��� %s, ���� %s, ���� %s", rs.getString(1) ,rs.getString(2) ,rs.getString(4) ,rs.getString(5) );
//		} catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//		}
		

