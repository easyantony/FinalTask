package by.tc.task01.service.impl;



import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.impl.FileApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{
    
    
	@Override
	public List<Appliance> find(Criteria criteria) throws ServiceException {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<Appliance> appliance = null;
		try {
			appliance = applianceDAO.find(criteria);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return appliance;
	}

	@Override
	public void add(Appliance appliance) throws ServiceException  {
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		try {
			applianceDAO.add(appliance);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean remove(Appliance appliance) throws ServiceException  {
		boolean itsRemove = true;
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		try {
			
			if(applianceDAO.remove(appliance)) {
				itsRemove = false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return itsRemove;
	}

}


