package miniproject1;

import java.util.Scanner;

public class Login implements ReserveMovie{
	

	@Override
	public void LogIn() {
		String id = "sung";
		String password = "1234";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("���̵� �Է����ּ��� :");
			String input_id = sc.next();
			
			if (id.equals(input_id)){
				System.out.print("��й�ȣ�� �Է����ּ��� :");
				
				while(true) {
				
				String input_pass = sc.next();
				if (input_pass.equals(password)) {
					
					System.out.println("�α��� �Ǿ����ϴ�.");
					break;
					
				}
				
				else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					System.out.print("��й�ȣ�� �Է����ּ��� :");
					
				}
				}
			 
			}else {
				System.out.print("���̵� Ʋ�Ƚ��ϴ�.");
				System.out.println();
//		
			}						
			break;
			}
			
		}
				 						
	

	@Override
	public void ReserveTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CancleTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CheckSeat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub
		
	}

}
