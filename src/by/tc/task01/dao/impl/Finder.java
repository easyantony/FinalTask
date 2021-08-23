package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.dao.DAOException;

public class Finder {

	public List<String> findByName(String applianceName) throws DAOException {

		List<String> appliances = new ArrayList<String>();
		String s;
		try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/appliances_db.txt"))) {

			while (reader.ready()) {
				s = reader.readLine();
				if (s.contains(applianceName)) {
					appliances.add(s);
				}

			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return appliances;

	}

	public List<String> findByParams(Map<String, Object> params) throws DAOException {
		List<String> appliances = new ArrayList<>();

		String s;
		boolean itsMyString;
		try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/appliances_db.txt"))) {
			while (reader.ready()) {
				itsMyString = true;
				s = reader.readLine();
				for (Map.Entry<String, Object> pair : params.entrySet()) {
					Pattern pattern = Pattern.compile(pair.getKey() + "=" + pair.getValue() + "\\b");
					Matcher matcher = pattern.matcher(s);
					if (!matcher.find()) {
						itsMyString = false;
					}
				}
				if (itsMyString) {
					appliances.add(s);
				}
				
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return appliances;

	}

	public List<String> findByNameAndParams(String applianceName, Map<String, Object> params) throws DAOException {

		List<String> result = new ArrayList<String>();
		List<String> appliance;

		appliance = findByName(applianceName);

		boolean itsMyString;
		for (int i = 0; i < appliance.size(); i++) {
			itsMyString = true;
			for (Map.Entry<String, Object> pair : params.entrySet()) {

				Pattern pattern = Pattern.compile(pair.getKey() + "=" + pair.getValue() + "\\b");
				Matcher matcher = pattern.matcher(appliance.get(i));
				if (!matcher.find()) {
					itsMyString = false;
					break;
				}
			}
			if (itsMyString) {
				result.add(appliance.get(i));
			}
			

		}

		return result;
	}
}
