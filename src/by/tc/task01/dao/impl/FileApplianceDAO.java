package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sun.tools.classfile.Dependency.Finder;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.dao.FinderFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.factory.ApplianceCreatorFactory;

public class FileApplianceDAO implements ApplianceDAO{

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException {

		List<Appliance> result = new ArrayList<>();
		List<String> applianceList;
		Map<String, Object> params = criteria.getCriteria();
		String searchGroupName = criteria.getGroupSearchName();

		ApplianceCreator appCreator = ApplianceCreatorFactory.getInstance().getAutoCreator();
		Finder finder = FinderFactory.getInstance().getFinder();

		if (criteria.getGroupSearchName() == null) {
			applianceList = finder.findByParams(params);

			for (int i = 0; i < applianceList.size(); i++) {

				result.add(appCreator.create(applianceList.get(i)));
			}
		} else if (params.size() == 0 && searchGroupName != null) {
			applianceList = finder.findByName(searchGroupName);
			for (int i = 0; i < applianceList.size(); i++) {
				result.add(appCreator.create(applianceList.get(i)));
			}
		} else if (params.size() > 0 && searchGroupName != null) {
			applianceList = finder.findByNameAndParams(searchGroupName, params);
			for (int i = 0; i < applianceList.size(); i++) {
				result.add(appCreator.create(applianceList.get(i)));
			}
		}
		return result;

	}

	@Override
	public void add(Appliance appliance) throws DAOException {
		List<String> applianceList = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/appliances_db.txt"))) {
			while (reader.ready()) {
				applianceList.add(reader.readLine());
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		applianceList.add(appliance.ApplianceToString());
		Collections.sort(applianceList);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/appliances_db.txt"))) {
			for (int i = 0; i < applianceList.size(); i++) {
				if (applianceList.get(i).length() > 0) {
					writer.write(applianceList.get(i) + "\n");
				}

			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public boolean remove(Appliance appliance) throws DAOException {
		
		boolean itsRemove = true;
		List<String> applianceList = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/appliances_db.txt"))) {
			while (reader.ready()) {
				applianceList.add(reader.readLine());
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}
		List<Appliance> appResultList = new ArrayList<Appliance>();
		ApplianceCreator appCreator = ApplianceCreatorFactory.getInstance().getAutoCreator();
		for (int i = 0; i < applianceList.size(); i++) {
			Appliance newAppliance = appCreator.create(applianceList.get(i));
			if (!newAppliance.equals(appliance)) {
				appResultList.add(newAppliance);
			}

		}
		if(applianceList.size()==appResultList.size()) {
			itsRemove = false;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/appliances_db.txt"))) {
			for (int i = 0; i < appResultList.size(); i++) {
				writer.write(appResultList.get(i).ApplianceToString() + "\n");
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}
		
		return itsRemove;

		
	}	
	
}


