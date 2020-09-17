import java.util.*;
public class JbabCalculator {
	@SuppressWarnings("resource")
	public JbabCalculator() {
		System.out.println("��������ʽ�����ո񣩣�����exit�˳�������������CMD");
		while (true) {
			System.out.print("JBAB CALCULATOR> ");
			Scanner s = new Scanner(System.in);
			String a = s.nextLine();
			if (a.equals("exit")) {
				System.out.println("�˳��ɹ�");
				JbabLauncher.printPrompt();
				break;
			} 
			if (a.equals("")) {
				continue;
			}
			String[] as = a.split(" ");
			if (as.length != 3) {
				System.out.println("���󣡼�����ÿ��ֻ�ܴ��������������������ʽ��");
				continue;
			}
			try {
				double value = evaluate(as);
				if ((int) value == value) {
					System.out.println((int) value);
				} else {
					System.out.println(value);
				}
			} catch (RuntimeException e) {
				String type = e.getMessage();
				if (type.equals("Ϊ��ĳ���")) {
					System.out.println("��������Ϊ�㣡");
					continue;
				} else if (type.equals("���������")) {
					System.out.println("������������");
					continue;
				} else {
					System.out.println("�����Ĵ���");
					continue;
				}
			}
 		}
	}
	public static double evaluate(String[] as) {
		String op = as[1];
		if (op.equals("+")) {
			return Double.parseDouble(as[0]) + Double.parseDouble(as[2]);
		} else if (op.equals("-")) {
			return Double.parseDouble(as[0]) - Double.parseDouble(as[2]);
		} else if (op.equals("*")) {
			return Double.parseDouble(as[0]) * Double.parseDouble(as[2]);
		} else if (op.equals("/")) {
			if (Double.parseDouble(as[2]) == 0) {
				throw new RuntimeException("Ϊ��ĳ���");
			}
			return Double.parseDouble(as[0]) / Double.parseDouble(as[2]);
		} else {
			throw new RuntimeException("���������");
		}
	}
}
