package sqlproject2;


import java.sql.SQLException;
import java.util.Scanner;

public class Sal {
	 int employee_id;
	 String first_name;
	 String last_name;
	 int salary;
	 String hire_date;
	

	public Sal() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Sal(int employee_id) {
		
		// TODO Auto-generated constructor stub
	}


	
	public Sal(String first_name, String last_name, int salary, String hire_date) {
		// TODO Auto-generated constructor stub
		this.first_name= first_name;
		this.last_name= last_name;
		this.salary= salary;
		this.hire_date = hire_date;
	
	}
	


	public static void main(String[] args) throws Exception {
		SalDao sd = new SalDao(); 
		Sal sal = new Sal();
		
		sd.connect();
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("�޴����");
			System.out.println("------");
			System.out.println("1. ��� �̸� ��� | 2. ��� ���� ��� | 3. ����� ���� ���� | 4. ����� ���� ���� | 5. ����");
			System.out.print("�Է�>>");
			int num =sc.nextInt();
			
		
		switch(num) {
			case 1 :
				System.out.println();
				System.out.println("�̸��� ����մϴ�.");
				System.out.println("-------------");
				sd.PrintName();
				break;
			case 2 :
				sd.Calculate();
				break;
			case 3 :
					sd.update(sal);
				break;
			case 4 :
			
				sd.remove(sal);
				break;
			case 5 :
				sd.close();
				break;
			default :
				System.out.println("�߸��� ��ȣ�Դϴ�.");
				break;
		}continue;
		
	    }
	}
	
}