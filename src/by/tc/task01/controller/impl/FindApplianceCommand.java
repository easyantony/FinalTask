package by.tc.task01.controller.impl;

import java.util.List;

import by.tc.task01.controller.Command;
import by.tc.task01.controller.util.RequestUtil;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class FindApplianceCommand implements Command {

	private static final int APPLIANCE_TYPE = 1;
	private static final String FIND_IN_ALL_PARAM = "all";

	@Override
	public String execute(String request) {

		
		String[] params = request.split("\\s+");
		String applianceType = params[APPLIANCE_TYPE].split("=")[1];
		Criteria criteria = new Criteria();
		if (!FIND_IN_ALL_PARAMS.equals(applianceType)) {
			criteria.setGroupSearchName(applianceType);
		}

		for (int i = 2; i < params.length; i++) {
			String[] applianceParams = params[i].split("=");
			criteria.add(applianceParams[0], applianceParams[1]);
		}
		String responce;
		ApplianceService service = ServiceFactory.getInstance().getApplianceService();
		try {
			List<Appliance> result = service.find(criteria);
			responce = "Found these appliances :\n";
			for(int i = 0; i < result.size(); i++) {
				responce = responce + result.get(i).ApplianceToString()+"\n";
			}
			
		} catch (ServiceException e) {

			responce = "Error";
		}
		return responce;
	}

}
