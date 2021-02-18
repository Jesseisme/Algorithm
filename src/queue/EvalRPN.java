package queue;

import java.util.Stack;

public class EvalRPN {
	 public int evalRPN(String[] tokens) {
		 Stack<Integer> stack = new Stack<Integer>();
		 for(int i= 0;i<tokens.length;i++){
			 if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
				 int num1 =  stack.pop();
				 int num2 = stack.pop();
				 int res = calculate(num1,num2,tokens[i]);
				 stack.push(res);
			 }
			 else{
				 stack.push(Integer.parseInt(tokens[i]));
			 }
		 }
		 return stack.pop();
	 }

	private int calculate(int num1, int num2, String tokens) {
		if(tokens.equals("+")){
			return num1+num2;
		}
		if(tokens.equals("-")){
			return num2-num1;
		}
		if(tokens.equals("*")){
			return num1*num2;
		}
		if(tokens.equals("/")){
			return num2/num1;
		}
		
		return 0;
	}
}
