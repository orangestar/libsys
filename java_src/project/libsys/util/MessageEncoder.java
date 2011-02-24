package project.libsys.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageEncoder {
	
	private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static String getMd5(String msg) {
		String s = null;
		if(msg != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(msg.getBytes());
				byte temp[] = md.digest();
				char str[] = new char[32];
				int idx = 0;
				for(int i = 0; i < 16; i++) {
					byte b = temp[i];
					str[idx++] = hexDigits[b >>> 4 & 0xF];
					str[idx++] = hexDigits[b & 0xF];
				}
				s = new String(str);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
}
