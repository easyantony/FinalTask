package by.tc.task01.controller;

public class FrontController {
	private static final int COMMAND_NAME = 0;
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {

		String[] params = request.split("\\s+",2);
		String commandName = params[COMMAND_NAME];
		
		String response;
		Command command;
		
		command = provider.takeCommand(commandName);
		response = command.execute(request);
		
		return response;
	}
	
	
}
