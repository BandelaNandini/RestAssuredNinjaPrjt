package UsingMethodchaining;

import org.testng.annotations.Test;

public class CreateMC_A {

	@Test
	public static CreateMC_A a() {
		System.out.println("a");
		return new CreateMC_A();
	}

	@Test
	public static CreateMC_A b() {
		System.out.println("b");
		return new CreateMC_A();
	}

	@Test
	public static CreateMC_B c() {
		System.out.println("c");
		return new CreateMC_B();
	}
}
