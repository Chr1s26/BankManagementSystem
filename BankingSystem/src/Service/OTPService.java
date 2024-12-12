package Service;

import Util.OTPUtil;

public class OTPService extends BaseService {

    private EmailSenderService emailSenderService;
    public static String sendOtp;

    public OTPService(String toEmail, String subject) {
        sendOtp = OTPUtil.generateOTP(6); 
        String emailContent = generateOtpEmailContent(sendOtp);
        this.emailSenderService = new EmailSenderService(toEmail, subject, emailContent);
    }

    public void sentOTPmail() {
        this.emailSenderService.setName("OTP Thread");
        this.emailSenderService.start();
    }

    public void validateOTP(String otp) throws Exception {
        if (otp.equals(sendOtp)) {
            System.out.println("OTP validation success !!!");
        } else {
            System.out.println("OTP validation failed !!!");
            throw new Exception("OTP validation failed !!!");
        }
    }

    private String generateOtpEmailContent(String otp) {
        return "<html>"
            + "<body style='font-family: Arial, sans-serif;'>"
            + "<div style='background-color: #f4f4f4; padding: 20px;'>"
            + "<h2 style='color: #4CAF50;'>Your OTP Code</h2>"
            + "<p style='font-size: 16px;'>Hello,</p>"
            + "<p style='font-size: 16px;'>Your OTP code is: <strong style='font-size: 18px; color: #4CAF50;'>" 
            + otp + "</strong></p>"
            + "<p style='font-size: 16px;'>This code is valid for 10 minutes.</p>"
            + "<p style='font-size: 16px;'>If you didn't request an OTP, please ignore this email.</p>"
            + "<br>"
            + "<p style='font-size: 14px; color: #888;'>Thanks,</p>"
            + "<p style='font-size: 14px; color: #888;'>Your Company Team</p>"
            + "</div>"
            + "</body>"
            + "</html>";
    }
}