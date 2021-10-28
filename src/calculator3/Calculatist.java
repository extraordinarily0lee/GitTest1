package calculator3;

public class Calculatist {
	float num;
	public float calculatist_go(float a,float b,String c) {
		switch (c) {
		case "+":
			num = a+b;
			break;
		case "-":
			num =  a-b;
			break;
		case "*":
			num = a*b;
			break;
		case "/":
			num = a/b;
			break;
		}
		return num;
	}
}
