import java.util.*;
public class JbabAprilFools {
	private static ArrayList<String> varNames = new ArrayList<>();
	private static ArrayList<String> values = new ArrayList<>();
	private static ArrayList<String> types = new ArrayList<>();
	private static ArrayList<String> allowtypes = new ArrayList<>();
	private static ArrayList<String> codeblocknames = new ArrayList<>();
	private static ArrayList<String> codeblockstatements = new ArrayList<>();
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		if (args.length != 1 || !args[0].equals("april")) {
			System.out.println("请从正规渠道进入，谢谢");
		} else {
			printPrompt();
			while (true) {
				Scanner s = new Scanner(System.in);
				String a = s.nextLine();
				runcomm(a);
			}
		}
	}
	public static void runcomm(String str) {
		if (str.startsWith("print")) {
			System.out.println(114514);
			printPrompt();
		} else if (str.equals("callUI")) {
			System.out.println("UI已经到了外太空，叫不回来了");
			printPrompt();
		} else if (str.startsWith("def")) {
			if (str.equals("def") || str.equals("def!")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String sa[] = str.split("\\!");
				String sa2[] = sa[1].split("\\=");
				String name = sa2[0];
				String value, type;
				try {
					value = sa2[1];
					value = value.trim();
					String val = value.split(":")[1];
					type = value.split(":")[0];
					if (val.startsWith("var_")) {
						String src = val.substring(4);
						String dest = name;
						String srcvalue = values.get(varNames.indexOf(src));
						if (varNames.contains(dest)) {
							if (!types.get(varNames.indexOf(dest)).equals(type)) {
								System.out.println("类型不匹配，值将设为nil");
							}
							else values.set(varNames.indexOf(dest), srcvalue);
						} else {
							varNames.add(dest);
							values.add(srcvalue);
							if (!allowtypes.contains("type")) {
								System.out.println("类型不存在");
							} else {
								if (type.equals("int")) {
									try {
										Integer.parseInt(srcvalue);
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(srcvalue), "nil");
										types.add("None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(srcvalue);
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(srcvalue), "nil");
										types.add("None");
									}
								}
								else types.add(type);
							}
						}
					} else {
						if (varNames.contains(name)) {
							values.set(varNames.indexOf(name), val);
							if (allowtypes.contains(type)) {
								if (type.equals("int")) {
									try {
										Integer.parseInt(val);
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(varNames.indexOf(name), "nil");
										types.set(varNames.indexOf(name), "None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(val);
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(varNames.indexOf(name), "nil");
										types.set(varNames.indexOf(name), "None");
									}
								}
								else types.set(varNames.indexOf(name), type);
							}
						} else {
							varNames.add(name);
							values.add(val);
							if (allowtypes.contains(type)) {
								if (type.equals("int")) {
									try {
										Integer.parseInt(val);
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(val), "nil");
										types.add("None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(val);
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(val), "nil");
										types.add("None");
									}
								}
								else types.add(type);
							} else System.out.println("类型不存在");
						}
					}
				} catch (Exception e) {
					type = str.split(":")[1];
					name = str.split("\\?")[1].split(":")[0];
					if (type.equals("codeblock")) {
						codeblocknames.add(name);
						codeblockstatements.add("");
					} else {
						value = "nil";
						System.out.println("出现错误，值将自动设为nil"); 
						if (varNames.contains(name)) { 
							values.set(varNames.indexOf(name), value);
						    types.set(varNames.indexOf(name), "None"); 
						} else { 
							varNames.add(name);
						    values.add(value);
						    types.add("None"); 
						}
					}
				}
				System.out.println("设置成功");
				printPrompt();
			}
		} else if (str.startsWith("var")) {
			try {
				String[] informations = str.split("\\!")[1].split(" ");
				String name = informations[0];
				String statements_un_handled = str.substring(6+name.length());
				int end = statements_un_handled.length();
				String statements = statements_un_handled.substring(0, end-1);
				if (codeblocknames.contains(name)) {
					int ind = codeblocknames.indexOf(name);
					codeblockstatements.set(ind, statements);
					System.out.println("定义成功");
					printPrompt();
				} else {
					codeblocknames.add(name);
					codeblockstatements.add(statements);
					System.out.println("定义成功");
					printPrompt();
				}
			} catch (Exception e) {
				System.out.println("语法错误");
				printPrompt();
			}
		} else if (str.startsWith("call")) {
			if (str.equals("call") || str.equals("call?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("不存在名为" + name + "的代码块");
					printPrompt();
				} else {
					String[] statements = codeblockstatements.get(codeblocknames.indexOf(name)).split("/");
					for (String statement: statements) {
						runcomm(statement);
					}
					printPrompt();
				}
			}
		} else if (str.startsWith("blockdel")) {
			if (str.equals("blockdel") || str.equals("blockdel?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("代码块" + name + "不存在或已被删除");
					printPrompt();
				} else {
					int i = codeblocknames.indexOf(name);
					codeblocknames.remove(i);
					codeblockstatements.remove(i);
					System.out.println("删除成功");
					printPrompt();
				}
			}
		} else if (str.startsWith("blockcontent")){
			if (str.equals("blockcontent") || str.equals("blockcontent?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("代码块" + name + "不存在或已被删除");
					printPrompt();
				} else {
					String[] statements = codeblockstatements.get(codeblocknames.indexOf(name)).split("/");
					System.out.println("代码块" + name + "有" + String.valueOf(statements.length) + "条语句");
					System.out.println("分别是：");
					for (String statement: statements) {
						System.out.println(statement);
					}
					printPrompt();
				}
			}
		} else if (str.equals("blocklist")) {
			String blocks[] = codeblocknames.toArray(new String[] {});
			System.out.println("共有" + blocks.length + "个代码块，分别为：");
			for (String name: blocks) {
				System.out.println(name);
			}
			printPrompt();
		} else if (str.startsWith("del")) {
			if (str.equals("del") || str.equals("del?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String name = sa[1];
				if (!varNames.contains(name)) {
					System.out.println("变量" + name + "不存在或已被删除");
					printPrompt();
				} else {
					int index = varNames.indexOf(name);
					varNames.remove(index);
					values.remove(index);
					System.out.println("删除成功");
					printPrompt();
				}
			}
		} else if (str.equals("time")) {
			System.out.println("4/1");
			printPrompt();
		} else if (str.startsWith("ejz")) {
			System.out.println("二进制？什么东西？传输密码来救你吗？");
			printPrompt();
		} else if (str.startsWith("run")) {
			System.out.println("你已无法通过运行程序与外界连接");
			printPrompt();
		} else if (str.equals("exit")) {
			System.out.println("整得开心不？");
			JbabLauncher.fromJAPF = true;
			JbabLauncher.main(null);
			System.exit(0);
		} else if (str.startsWith("wiki")) {
			System.out.println("这都什么年代了，还用wiki？");
			printPrompt();
		} else if (str.startsWith("type")) {
			if (str.equals("type") || str.equals("type?")) {
				System.out.println("语法错误");
			} else {
				String name = str.split("\\?")[1];
				if (codeblocknames.contains(name)) {
					System.out.println("变量的类型为：代码块");
				} else if (varNames.contains(name)) {
					System.out.print("变量的类型为：");
					String type = types.get(varNames.indexOf(name));
					System.out.println(type);
				} else {
					System.out.println("变量不存在或已被删除");
				}
			}
			printPrompt();
		} else if (varNames.contains(str)) {
			System.out.println(values.get(varNames.indexOf(str)));
			printPrompt();
		} else if (codeblocknames.contains(str)) {
			System.out.println("<code block " + str + ">");
			printPrompt();
	    } else if (str.startsWith("blockadd")) {
	    	if (str.equals("blockadd") || str.equals("blockadd?")) {
	    		System.out.println("语法错误");
	    	} else {
	    		String inf = str.substring(9);
	    		String blockname = inf.split(":")[0];
	    		String blockstate = inf.split(":")[1];
	    		if (!codeblocknames.contains(blockname)) {
	    			System.out.println("代码块不存在或已被删除");
	    		} else {
	    			int id = codeblocknames.indexOf(blockname);
	    			String val = codeblockstatements.get(id);
	    			if (val.equals("")) {
	    				codeblockstatements.set(id, blockstate);
	    			} else {
	    				codeblockstatements.set(id, val + "/" + blockstate);
	    			}
	    			System.out.println("语句添加成功");
	    		}
	    	}
	    	printPrompt();
	    } else {
	    	System.out.println("有这个命令吗");
	    	printPrompt();
	    }
	}
	public static void printPrompt() {
		System.out.print("JAPF CMD> ");
	}
}
