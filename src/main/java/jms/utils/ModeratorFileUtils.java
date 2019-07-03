package jms.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;



public final class ModeratorFileUtils {

	static String PROJECT_PATH = System.getProperty("user.dir");
	static String SEPARATOR = System.getProperty("file.separator");
	static String ROOT_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "upload";
	static int fileSize;
	public static File createFolder(String folderName) {

		File uploadDir = new File(ROOT_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		File folder = new File(uploadDir.getAbsolutePath() + File.separator + folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}

		return folder;
	}
	
	
	public static File createFolderUpload() {

		File uploadDir = new File(ROOT_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		

		return uploadDir;
	}
	
	
	public static void createImageInUpload( MultipartFile file1, MultipartFile file2, 
			MultipartFile file3) throws IOException {
	
		File uploadDir = new File(ROOT_PATH);
		if (!file1.isEmpty() && file1 != null) {
			BufferedImage image1 = ImageIO.read(new ByteArrayInputStream(file1.getBytes()));
			File destination1 = new File(uploadDir.getAbsolutePath() + SEPARATOR + file1.getOriginalFilename());
			ImageIO.write(image1, "png", destination1);
		}
	
			if (!file2.isEmpty() && file2 != null) {
				BufferedImage image2 = ImageIO.read(new ByteArrayInputStream(file2.getBytes()));
				File destination2 = new File(uploadDir.getAbsolutePath()  + SEPARATOR + file2.getOriginalFilename());
				ImageIO.write(image2, "png", destination2);
			}
			
			if (!file3.isEmpty() && file3 != null) {
				BufferedImage image3 = ImageIO.read(new ByteArrayInputStream(file3.getBytes()));
				File destination3 = new File(uploadDir.getAbsolutePath()  + SEPARATOR + file3.getOriginalFilename());
				ImageIO.write(image3, "png", destination3);
			}
			
		
	
	}
	
	
	
	public static void createImage(String folderName, MultipartFile file1, MultipartFile file2, 
			MultipartFile file3) throws IOException {
		if (!file1.isEmpty() && file1 != null) {
			BufferedImage image1 = ImageIO.read(new ByteArrayInputStream(file1.getBytes()));
			File destination1 = new File(createFolder(folderName).getAbsolutePath() + SEPARATOR + file1.getOriginalFilename());
			ImageIO.write(image1, "png", destination1);
		}	
			if (!file2.isEmpty() && file2 != null) {
				BufferedImage image2 = ImageIO.read(new ByteArrayInputStream(file2.getBytes()));
				File destination2 = new File(createFolder(folderName).getAbsolutePath() + SEPARATOR + file2.getOriginalFilename());
				ImageIO.write(image2, "png", destination2);
			}
			
			if (!file3.isEmpty() && file3 != null) {
				BufferedImage image3 = ImageIO.read(new ByteArrayInputStream(file3.getBytes()));
				File destination3 = new File(createFolder(folderName).getAbsolutePath() + SEPARATOR + file3.getOriginalFilename());
				ImageIO.write(image3, "png", destination3);
			}
			
		
	
	}
	
	public static String getImage(String folderName, String image) throws IOException {
		
		File file = null;
		byte[] encodeFileToByte = null;
		String encodedFile = null;

		System.out.println("Image: " + image);
		String defaultPath = ROOT_PATH + SEPARATOR + "default.png";
	
		
			if (image != null && image != "") {
			
			file = new File(ROOT_PATH + SEPARATOR  + image);    
			
			if(!file.exists()) { 
				file = new File(defaultPath); 
			}
		} else {
			file = new File(defaultPath);
		}
		
		System.out.println(file.getAbsolutePath());	
		encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		encodedFile = new String(encodeFileToByte);
		
		return encodedFile;
	}
	
	
 
public static String getImage2(String image2) throws IOException {
		
		File file = null;
		byte[] encodeFileToByte = null;
		String encodedFile = null;

		System.out.println("Image: " + image2);
		String defaultPath = ROOT_PATH + SEPARATOR + "default.png";
	
		
			if (image2 != null && image2 != "") {
			
				file = new File(ROOT_PATH + SEPARATOR  + image2);
			
			if(!file.exists() ) { 
				file = new File(defaultPath); 
			}
		
			
		} else {
			file = new File(defaultPath);
		}
		
		System.out.println(file.getAbsolutePath());	
		encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		encodedFile = new String(encodeFileToByte);
		
		return encodedFile;
	}
	
	


}
