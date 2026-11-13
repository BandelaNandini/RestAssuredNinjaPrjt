package EncryptionAndDecryptionTest;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncryptDecryptDataTest {

	@Test
	public void encodeAndDecodeTest() {
		String encrypted_data = new String(Base64.getEncoder().encode("Nandini".getBytes()));

		System.out.println("Encrypted data : " + encrypted_data);

		String decrypted_data = new String(Base64.getDecoder().decode(encrypted_data.getBytes()));

		System.out.println("Decrypted data : " + decrypted_data);
	}
}
