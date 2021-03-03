package Mk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * Static class to hash an object using MD5 algorithm
 * @author Motyak
 */
public class MD5 {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		String str = "content";

		System.out.println("Java object hash code :");
		System.out.println(str.hashCode());

		System.out.println("MD5 hash :");
		System.out.println(MD5.hash("content"));
	}

	/**
	 * Hash an object using MD5 algorithm
	 * @param obj any object
	 * @return the MD5 hash value as a String
	 * @throws IOException if writing the object to object output stream fails
	 * @throws NoSuchAlgorithmException this will never happen
	 */
	static String hash(Object obj) throws IOException, NoSuchAlgorithmException {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;

		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(baos.toByteArray());

			return DatatypeConverter.printHexBinary(thedigest).toUpperCase();
		}
		finally {
			oos.close();
			baos.close();
		}
	}
}
