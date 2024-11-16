package Util;

import java.util.Random;

public class OTPUtil {
	
	public static String generateOTP(int length) {
		Random random = new Random();
		StringBuilder otp = new StringBuilder();
		for(int i = 0; i < length; i++) {
			otp.append(random.nextInt(10));
		}
		
		return otp.toString();
	}
	
}
