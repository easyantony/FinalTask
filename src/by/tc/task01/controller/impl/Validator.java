package by.tc.task01.controller.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.controller.CommandName;

public class Validator {
	
	public static boolean requestValidator(String request) {
		boolean isValid = false;
		Pattern pattern = Pattern.compile(CommandName.ADD.toString());
		Matcher matcher = pattern.matcher(request.toUpperCase());
		if(matcher.find()) {
			isValid = true;
		}
		matcher.reset();
		
		pattern = Pattern.compile(CommandName.FIND.toString());
		matcher = pattern.matcher(request.toUpperCase());
		
		if(matcher.find()) {
			isValid = true;
		}
		matcher.reset();
		
		pattern = Pattern.compile(CommandName.REMOVE.toString());
		matcher = pattern.matcher(request.toUpperCase());
		
		if(matcher.find()) {
			isValid = true;
		}
		return isValid;

	}
}