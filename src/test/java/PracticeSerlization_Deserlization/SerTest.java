package PracticeSerlization_Deserlization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class templeRun implements Serializable {
	// Serializable is a marker interface where it doesn't have any abstract method
	// Used to indicate only that is serializable

	String name;
	int life;
	int score;
	int level;

	public templeRun(String name, int life, int score, int level) {
		super();
		this.name = name;
		this.life = life;
		this.score = score;
		this.level = level;
	}

}

public class SerTest {

	public static void main(String[] args) throws IOException {

		templeRun t = new templeRun("KarPav", 3, 70000, 60);
		FileOutputStream fos = new FileOutputStream("./jobj_binary");
		ObjectOutputStream objos = new ObjectOutputStream(fos);
		objos.writeObject(t);
		System.out.println("===Done===");

	}
}
