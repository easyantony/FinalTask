package by.tc.task01.controllerold;

import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;

public class Controller {
	
	private static final int COMMAND_NAME = 0;
	private static final int APPLIANE_TYPE = 1;
	private static final String FIND_IN_ALL_PARAM = "all";
	
	public String doAction(String request) {
		// validate request
		
		String[] params = request.split("\\s+");
		
		String commandName = params[COMMAND_NAME];
		
		Criteria criteria = new Criteria();
		
		//request = "find type=Oven CAPACITY=4 HEIGHT=2";
		
		String applianceType = params[APPLIANE_TYPE].split("=")[1];
		if(!FIND_IN_ALL_PARAM.equals(applianceType)) {
			criteria.setGroupSearchName(applianceType);
		}
		
		for(int i = 2; i < params.length; i++) {
			String[] applianceParam = params[i].split("=");
			criteria.add(applianceParam[0], applianceParam[1]);
		}
		
		String response;
		switch(commandName) {
		case "FIND":
			ServiceFactory factory = ServiceFactory.getInstance(); 
			ApplianceService service = factory.getApplianceService();
			
			try {
				List<Appliance> result = service.find(criteria);
				response = "OK - " + result.toString();
			} catch (ServiceException e) {
				// log
				response = "Sorry!!! Error."; 
			}
			
			return response;
		case "ADD":
			return null;
		case "REMOVE":
			return null;
		}
		
		return null;
		
		
	}

}
