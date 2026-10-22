package UsingStaticImport;

import org.testng.annotations.Test;

public class CreateStaticMethods {

	@Test
	public static void given() {
		System.out.println("Given method");
	}

	@Test
	public static void when() {
		System.out.println("When method");
	}

	@Test
	public static void then() {
		System.out.println("Then method");
	}
}
