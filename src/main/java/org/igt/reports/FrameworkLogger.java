package org.igt.reports;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.igt.enums.LogType;

public class FrameworkLogger {
	
	private FrameworkLogger() {
	}
	
	//Inline lambda variable
	public static Consumer<String> Pass = (message) -> ExtentManager.getExtentTest().pass(message);
	public static Consumer<String> Fail = (message) -> ExtentManager.getExtentTest().fail(message);
	public static Consumer<String> Skip = (message) -> ExtentManager.getExtentTest().skip(message);
	public static Consumer<String> Info = (message) -> ExtentManager.getExtentTest().info(message);
	public static Consumer<String> Console = (message) -> System.out.println("Info-->"+message);
	public static Consumer<String> ConsoleAndExtentReportPass = Pass.andThen(Console);
	public static Consumer<String> ConsoleAndExtentReportFail = Fail.andThen(Console);
	
	public static Map<LogType, Consumer<String>> map = new EnumMap<>(LogType.class);
	
	static {
		map.put(LogType.PASS, Pass);
		map.put(LogType.FAIL, Fail);
		map.put(LogType.SKIP, Skip);
		map.put(LogType.INFO, Info);
		map.put(LogType.CONSOLE, Console);
		map.put(LogType.CONSOLEANDEXTENTPASS, ConsoleAndExtentReportPass);
	}

	public static void log(LogType status, String message) {
		map.get(status).accept(message);
	}
}
