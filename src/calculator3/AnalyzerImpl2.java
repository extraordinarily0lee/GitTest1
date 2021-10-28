package calculator3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AnalyzerImpl2 implements Analyzer{
	
	public String cal(String srcString){
		
		if(srcString.length()==0) {
			return "false";
		}
		
		ScriptEngineManager aEngineManager = new ScriptEngineManager();
		
		for(ScriptEngineFactory aEngineFactory : aEngineManager.getEngineFactories()) {
			System.out.println(aEngineFactory.getEngineName());
			System.out.println(aEngineFactory.getNames());
		}
		
		ScriptEngine aEngine = aEngineManager.getEngineByName("JavaScript");
		try {
			String resultString = aEngine.eval(srcString).toString();
			if(resultString.length()>7) {
				return resultString.substring(0,6);
			}
			return resultString;
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
}