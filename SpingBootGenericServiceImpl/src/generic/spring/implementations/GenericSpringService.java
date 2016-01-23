package generic.spring.implementations;

public class GenericSpringService {
	public static String baseMethod(String serviceName, String operationName, String soapAction,String postString)
	{	
		return postString;
	}
	
	public static Object getMonitorObject(){
		return "Stats";
	}
}
