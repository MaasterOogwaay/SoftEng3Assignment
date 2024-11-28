package newsAgentPackage;

import exceptionHandlerPackage.ExceptionHandler;

public class NewsAgent {
	
	private int id;
	private String username;
	private String password;
	
	
	
	public NewsAgent(String username, String password) throws ExceptionHandler {
		id = 0;
		try {
			validateUserName(username);
			validatePassWord(password);
		} catch (ExceptionHandler e) {
			throw e;
		}
		
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return username;
	}
	
	public void setUsername(String userName) {
		this.username = userName;
	}
	
	public String getPassWord() {
		return password;
	}
	
	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	
	public static void validateUserName(String userName) throws ExceptionHandler {
		if (userName.isBlank() || userName.isEmpty() || userName == null)
			throw new ExceptionHandler("Username NOT specified");
		else if (userName.length() < 2)
			throw new ExceptionHandler("Username does not meet minimum length requirements");
		else if (userName.length() > 50)
			throw new ExceptionHandler("Username exceeds maximum length requirements");
	}
	
	public static void validatePassWord(String passWord) throws ExceptionHandler {
		if (passWord.isBlank() || passWord.isEmpty())
			throw new ExceptionHandler("Password NOT specified");
		else if (passWord.length() < 2)
			throw new ExceptionHandler("Password does not meet minimum length requirements");
		else if (passWord.length() > 10)
			throw new ExceptionHandler("Password exceeds maximum length requirements");
	}

}
