package Mk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Static class for reading from / writing to text files
 * @author Motyak
 */
public class TextFile {

	public static void main(String[] args) throws Exception {
		String userDir = System.getProperty("user.dir") + File.separator;
		String content = new String("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12");

		System.out.println("creating file1 with the content of str..");
		TextFile.write(content, userDir + "file1");

		System.out.println("renaming file1 into file2..");
		TextFile.rename(userDir, "file1", "file2");

		System.out.println("reading and printing file2 content..");
		System.out.println(TextFile.read(userDir + "file2"));

		System.out.println("printing an overview of file2 (max 10 lines)..");
		System.out.println(TextFile.overview(userDir + "file2", 10));

		System.out.println("deleting file2..");
		new File(userDir + "file2").delete();
	}

	/**
	 * Read file content
	 * @param filePath the absolute path of the targeted file
	 * @return the content of the targeted file as a String
	 * @throws IOException if there's a problem finding/reading the file
	 */
	public static String read(String filePath) throws IOException {
		InputStream is = new FileInputStream(filePath);
		BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();

		while(line != null) {
		   sb.append(line).append("\n");
		   line = buf.readLine();
		}

		buf.close();
		sb.setLength(sb.length() - 1);	//Gets rid of the last line break to keep the exact same content

		return sb.toString();
	}

	/**
	 * Write stringable to file (overwrite if exists, otherwise create it)
	 * @param stringable the content to write into the file, will use 'toString()' implementation
	 * @param filePath the absolute path of the file to create
	 * @throws IOException if there's a problem finding/writing the file
	 */
	public static void write(Object stringable, String filePath) throws IOException {
		TextFile.write(stringable.toString(), filePath, false);
	}

	/**
	 * Append stringable to file (create the file if not exists)
	 * @param stringable the content to write into the file, will use 'toString()' implementation
	 * @param filePath the absolute path of the file to create
	 * @throws IOException if there's a problem finding/writing the file
	 */
	public static void append(Object stringable, String filePath) throws IOException {
		TextFile.write(stringable.toString(), filePath, true);
	}

	private static void write(String str, String filePath, boolean append) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append));
		writer.write(str);
	    writer.close();
	}

	/**
	 * Read a file and return an overview of it
	 * @param filePath the absolute path of the targeted file
	 * @param nbOfLines the overview length
	 * @return an overview of the targeted file
	 * @throws IOException if there's a problem finding/reading the file
	 */
	public static String overview(String filePath, int nbOfLines) throws IOException {
		long totalNbOfLines = TextFile.nbOfLines(filePath);

		if(totalNbOfLines <= nbOfLines)
			return TextFile.read(filePath);
		else {
			InputStream is = new FileInputStream(filePath);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			for(int i = 1 ; i <= nbOfLines / 2 ; ++i)
				sb.append(buf.readLine()).append("\n");
			sb.append("...\n");
			for(int i = 1 ; i <= totalNbOfLines - nbOfLines ; ++i)
				buf.readLine();
			for(int i = 1 ; i <= nbOfLines / 2 ; ++i)
				sb.append(buf.readLine()).append("\n");

			buf.close();
			sb.setLength(sb.length() - 1);

			return sb.toString();
		}
	}

	/**
	 * Rename a file
	 * @param dirPath the directory containing the file to rename
	 * @param fileName the name of the file to rename
	 * @param newFileName the new file name
	 * @throws Exception if there's a problem finding/renaming the file
	 */
	public static void rename(String dirPath, String fileName, String newFileName) throws Exception {
		TextFile.rename(dirPath, fileName, newFileName, false);
	}

	/**
	 * Rename a file, overwrite if a file is already named as new file name
	 * @param dirPath the directory containing the file to rename
	 * @param fileName the name of the file to rename
	 * @param newFileName the new file name
	 * @throws Exception if there's a problem finding/renaming the file
	 */
	public static void renameAndOverwrite(String dirPath, String fileName, String newFileName) throws Exception {
		TextFile.rename(dirPath, fileName, newFileName, true);
	}

	private static void rename(String dirPath, String fileName, String newFileName, boolean overwrite) throws Exception {
		Path source = Paths.get(dirPath + fileName);
		File file = new File(dirPath + newFileName);
		if(file.exists()) {
			if(overwrite)
				file.delete();
			else
				throw new Exception("Cannot rename : the name of the file already exists.");
		}
		Files.move(source, source.resolveSibling(newFileName));
	}

	private static long nbOfLines(String filePath) throws IOException {
		return Files.lines(Paths.get(filePath)).count();
	}
}
