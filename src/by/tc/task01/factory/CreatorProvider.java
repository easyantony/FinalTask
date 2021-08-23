package by.tc.task01.factory;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.ApplianceType;

public class CreatorProvider {

private Map<ApplianceType, ApplianceCreator> creator = new HashMap<ApplianceType, ApplianceCreator>();
	
	
	public CreatorProvider() {
		creator.put(ApplianceType.LAPTOP, ApplianceCreatorFactory.getInstance().getLaptopCreator());
		creator.put(ApplianceType.OVEN, ApplianceCreatorFactory.getInstance().getOvenCreator());
		creator.put(ApplianceType.REFRIGERATOR, ApplianceCreatorFactory.getInstance().getRefrigeratorCreator());
		creator.put(ApplianceType.SPEAKERS, ApplianceCreatorFactory.getInstance().getSpeakersCreator());
		creator.put(ApplianceType.TABLETPC, ApplianceCreatorFactory.getInstance().getTabletPCCreator());
		creator.put(ApplianceType.VACUUMCLEANER, ApplianceCreatorFactory.getInstance().getVacuumCleanerCreator());		
	}
	
	public ApplianceCreator takeCreator(String applianceName){
		
		
		ApplianceType appType = ApplianceType.valueOf(applianceName.toUpperCase());
		ApplianceCreator appCreator = creator.get(appType);

		
		
		return   appCreator;
	}
}