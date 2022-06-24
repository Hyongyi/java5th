package sqlproject2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;




	public class SalDao {
    private Connection conn;
	int selectNum;
	Scanner sc = new Scanner(System.in);
	
	
    public Connection connect() throws Exception {
    	conn = DBconn.getConnection();
		System.out.println("����̹� �ε���...\n\n");
		System.out.println("-----------------------");
		System.out.println("|�����ͺ��̽��� �����߽��ϴ�.|");
		System.out.println("-----------------------\n\n");
		return conn;
    }
    
    
    
    public void close() {
		System.out.println("�ý����� �����մϴ�.");
		 System.exit(0);
    }
    
    
    public void PrintName() throws SQLException {
		Statement stat = null;
		ResultSet rs = null;
		
		stat = conn.createStatement();
		rs = stat.executeQuery("SELECT first_name|| ' '|| last_name from Test05");
		
		try {
	    	while(rs.next()) {
	    		String ss1 = rs.getString(1);
	    		System.out.printf("�̸� : %s\n", rs.getString(1));
	    	}
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
    }
    
    
    public void Calculate() {
    	PreparedStatement ps = null;
		Statement stat = null;
		ResultSet rs = null;
		
		
		try {  
			 
		Scanner scan= new Scanner(System.in);
	        System.out.print("�˻��ϰ� ���� ��� �̸��� �Է��ϼ���>>");
	        String name =scan.nextLine();
    	
	   
	        
    	String sql = "SELECT first_name||' '||last_name, to_char(hire_date, 'yyyy\"�� \"mm\"�� \"dd\"�� \"'), to_char(hire_date, 'yyyy'),salary, 12*salary, employee_id from Test05 "
    			+ "where first_name= ?" + "order by hire_date";
			
		ps = conn.prepareStatement(sql);
    	ps.setString(1, name);
    	stat = conn.createStatement();
    	rs = ps.executeQuery();

		while(rs.next()) {
			
				double ss5 =rs.getInt(5);
				int cw = 2008-rs.getInt(3);
				double rate = 0.03;
		
	
				boolean result = true;
				System.out.printf("��� ��ȣ : %s �̸� : %s, �Ի��� : %s, ���� : %s, ���� : %s", rs.getString(6), rs.getString(1), rs.getString(2), rs.getInt(4),rs.getInt(5));
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
				System.out.printf("\n�λ�� ���� : %s\n", Math.round(ss5*100)/100.0);	
			}
		
		}
			}catch (SQLException e) {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ��Է����ּ���.");
			}
		}
		
		
	
	
    public void update(Sal sal) {
    	try {
    	
    	System.out.println("������ ���� ��ȣ�� �Է��ϼ���>>");
		sal.employee_id = sc.nextInt();
		System.out.print("������ First name �Է� >>");
		sal.first_name = sc.next();
		System.out.print("������ Last name �Է� >>");
		sal.last_name = sc.next();
		System.out.print("������ ���� �Է� >>");
		sal.salary = sc.nextInt();
		System.out.print("������ �Ի��� �Է� >>");
		sal.hire_date = sc.next();
    	PreparedStatement ps = null;
    	String sql = "Update Test05 " + 
    			"set first_name = ?, last_name = ?, salary = ?, hire_date = ?" + 
    			"where employee_id =?";
    	
		ps = conn.prepareStatement(sql);
		
	
    	ps.setString(1, sal.first_name);
    	ps.setString(2, sal.last_name);
    	ps.setInt(3, sal.salary);
    	ps.setString(4, sal.hire_date);
    	ps.setInt(5, sal.employee_id);
    	System.out.println("�����Ǿ����ϴ�.");
    } catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���");
	}
    	
    }
    
    
    
   
    public void remove(Sal sal) {
    	try {
    	System.out.println("������ ���� ��ȣ�� �Է��ϼ���>>");
		sal.employee_id = sc.nextInt();	
    		
    	PreparedStatement ps = null;
    	String sql = "delete from Test05 where employee_id = ?";
    	ps = conn.prepareStatement(sql);
		ps.setInt(1, sal.employee_id);
		
    	System.out.println("�����Ǿ����ϴ�.");
    	} catch (Exception e) {
    		System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���");
		}
    	
    }
    
    public ArrayList<Sal> lists() throws SQLException {
    	ResultSet rs = null;
    	Statement stat = conn.createStatement();
    	rs = stat.executeQuery("select * from Test04");
    	ArrayList<Sal> list = new ArrayList<Sal>();
    	while(rs.next()) {
    		String first_name =rs.getString("first_name");
    		String last_name =rs.getString("last_name");
    		int salary =rs.getInt("salary");
    		String hire_date=rs.getString("hire_date");
    		list.add(new Sal(first_name, last_name, salary, hire_date));
    	}
		return lists();
    	
    }
    
    
    public void menu() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("�޴����");
		System.out.println("------");
		System.out.println("1. ��� �̸� ��� | 2. ��� ���� ��� | 3. ����� ���� ���� | 4. ����� ���� ���� | 5. ����");
		System.out.print("�Է�>>");
		int num =sc.nextInt();
    }

    
    
}
    