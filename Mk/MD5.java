package Mk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	public static String hash(Object obj) throws IOException, NoSuchAlgorithmException {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;

		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digestBytes = md.digest(baos.toByteArray());
			BigInteger no = new BigInteger(1, digestBytes);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext; 
	        }
	        return hashtext.toUpperCase(); 
		}
		finally {
			oos.close();
			baos.close();
		}
	}
}
