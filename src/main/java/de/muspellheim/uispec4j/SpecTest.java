package de.muspellheim.uispec4j;

import org.uispec4j.UISpec4J;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowInterceptor;
import org.uispec4j.utils.MainClassTrigger;

public class SpecTest {

	static {
		UISpec4J.init();
	}

	public static void main(String[] args) {
		Window window = WindowInterceptor.run(new MainClassTrigger(Main.class));
		window.titleEquals("UISpec4J").check();

		System.exit(0);
	}

}
