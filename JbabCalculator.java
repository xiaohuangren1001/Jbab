import java.util.*;
public class JbabCalculator {
	@SuppressWarnings("resource")
	public JbabCalculator() {
		System.out.println("请输入算式（带空格），输入exit退出计算器，进入CMD");
		while (true) {
			System.out.print("JBAB CALCULATOR> ");
			Scanner s = new Scanner(System.in);
			String a = s.nextLine();
			if (a.equals("exit")) {
				System.out.println("退出成功");
				JbabLauncher.printPrompt();
				break;
			} 
			if (a.equals("")) {
				continue;
			}
			String[] as = a.split(" ");
			if (as.length != 3) {
				System.out.println("错误！计算器每次只能处理带有两个操作数的算式！");
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
				if (type.equals("为零的除数")) {
					System.out.println("除数不可为零！");
					continue;
				} else if (type.equals("运算符错误")) {
					System.out.println("错误的运算符！");
					continue;
				} else {
					System.out.println("其他的错误！");
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
				throw new RuntimeException("为零的除数");
			}
			return Double.parseDouble(as[0]) / Double.parseDouble(as[2]);
		} else {
			throw new RuntimeException("运算符错误");
		}
	}
}
