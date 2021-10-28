package calculator3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzerImpl implements Analyzer{
	private String result;
	private Calculatist aCalculatist = new Calculatist();
	
	//��������
	public String cal(String srcString) {
		
		if(srcString.length()==0) {
			System.out.println("��������-���ַ�����"+false+"�������� "+"\"\"");
			return "false";
		}
		
		
		//����
		boolean f1 = false;
		boolean f2 = false;
		boolean f3 = false;
		boolean f4 = false;
		Pattern aPattern = Pattern.compile("^\\D");
		Pattern bPattern = Pattern.compile("\\D$");
		Pattern cPattern = Pattern.compile("\\D\\D");
		Pattern dPattern = Pattern.compile("/0");
		Matcher s1 = aPattern.matcher(srcString);
		Matcher s2 = bPattern.matcher(srcString);
		Matcher s3 = cPattern.matcher(srcString);
		Matcher s4 = dPattern.matcher(srcString);
		f1 = s1.find();
		f2 = s2.find();
		f3 = s3.find();
		f4 = s4.find();
		//����
		
		if(f1) {System.out.println("��������-��ͷ�Ƿ��ţ�"+f1+"�������� "+s1.group());}
		if(f2) {System.out.println("��������-��β�Ƿ��ţ�"+f2+"�������� "+s2.group());}
		if(f3) {System.out.println("��������-�����������ţ�"+f3+"�������� "+s3.group());}
		if(f4) {System.out.println("��������-0��Ϊ������"+f4+"�������� "+s4.group());}
		
		
		
		if(f1||f2||f3||f4) {
			result = "false";
			return result;
		}
		
		
		//����
		Pattern aPattern2 = Pattern.compile("[\\D&&[^\\.]]");
		Pattern aPattern3 = Pattern.compile("(\\d(\\.)*)+");
		String[] numStrings = aPattern2.split(srcString);
/*����*/System.out.printf("���ַ���������%d������\n",numStrings.length);
		String[] markStrings_a = aPattern3.split(srcString);
		if(markStrings_a.length-1<0) {
			return ""+numStrings[0];
		}
		String[] markStrings_a2 = new String[markStrings_a.length-1];
/*����*/System.out.printf("���ַ���������%d������\n",markStrings_a.length);
/*����*/System.out.printf("��һ�������ǣ�%s\n",markStrings_a[0]);
		String[] markStrings_b = new String[markStrings_a.length];
		float[] cals_a = new float[20];
		float[] cals_b = new float[20];
		int cals_b_num = 0;
		int marks_b_num = 0;
		for(int a = 0;a<markStrings_a2.length;a++) {
			markStrings_a2[a] = markStrings_a[a+1];
		}
		for(int a = 0;a<numStrings.length;a++) {
			cals_a[a] = Float.parseFloat(numStrings[a]);
		}
		for(int a = 0;a<markStrings_a2.length;a++) {
			if(markStrings_a2[a].equals("+")||markStrings_a2[a].equals("-")) {
				markStrings_b[marks_b_num] = markStrings_a2[a];
				marks_b_num++;
				cals_b[cals_b_num] = cals_a[a];
				cals_b_num++;
			}
			if(markStrings_a2[a].equals("*")||markStrings_a2[a].equals("/")) {
				cals_a[a+1] = aCalculatist.calculatist_go(cals_a[a], cals_a[a+1], markStrings_a2[a]);
			}
			if(a==markStrings_a2.length-1) {
				cals_b[cals_b_num] = cals_a[a+1];
			}
		}
		for(int a = 0;a<marks_b_num;a++) {
			cals_b[a+1] = aCalculatist.calculatist_go(cals_b[a],cals_b[a+1], markStrings_b[a]);	
		}
		result = ""+cals_b[cals_b_num];		
		
		
		/*����һ�֣���״̬�������滻��ƥ��123*566���������ַ����������滻Ϊ�����������˳��ٷ����Ӽ����ƺ������*/
		
		
		
		
		return result;
	}
}
