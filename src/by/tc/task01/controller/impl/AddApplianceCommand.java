package by.tc.task01.controller.impl;

import by.tc.task01.controller.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.factory.ApplianceCreatorFactory;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class AddApplianceCommand implements Command {
	
	private static final int APPLIANCE_TYPE = 1;

	@Override
	public String execute(String request) {
		String responce;
		String[] params = request.split("\\s+");
		String applianceName = params[APPLIANCE_TYPE].split("=")[1];
		AutoApplianceCreator creator = ApplianceCreatorFactory.getInstance().getAutoCreator();
		Appliance appliance = creator.create(applianceName, request);
		ApplianceService service = ServiceFactory.getInstance().getApplianceService();
		try {
			service.add(appliance);
			responce = "Appliance was added";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			responce = "Appliance was not added";
		}
		return responce;
	}

}
