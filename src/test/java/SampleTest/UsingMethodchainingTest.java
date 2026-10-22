package SampleTest;

import org.testng.annotations.Test;

import static UsingMethodchaining.CreateMC_A.*;

public class UsingMethodchainingTest {

	@Test
	public void sample() {
//		CreateMC_A mc=new CreateMC_A();
		// Return type is void
//		mc.a();
//		mc.b();
//		mc.c();

		// Return type of all methods is self class ref
//		mc.a().b().c();

		// Return type of a,b is a class and
		// c is b class so we can call d()
//		mc.a().b().c().d();

		// If we use static import no need to create obj
		a().b().c().d();

		// This type of architecture we can see in Rest assured***
	}
}
