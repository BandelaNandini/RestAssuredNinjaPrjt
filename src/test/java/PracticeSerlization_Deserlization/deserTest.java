package PracticeSerlization_Deserlization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class deserTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("./jobj_binary");
		ObjectInputStream ois = new ObjectInputStream(fis);

		templeRun t = (templeRun) ois.readObject();

		System.out.println(t.level);
		System.out.println(t.life);
		System.out.println(t.score);
		System.err.println(t.name);

	}
}
