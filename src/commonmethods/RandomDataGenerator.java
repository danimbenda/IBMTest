package commonmethods;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
	
	 static String CHAR_L ="abcdefghijklmnopqrstuvwxyz";
     static String CHAR_U="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     static String NUM="1234567890";
     static String CHAR_S="!@#$%^&*()_=+";
     static final int PASSWORD_LENGTH = 8;
     

	/**
	 * This method is to generate random strings
	 * @param length
	 * @return
	 */
    public static String generateRandomString(int length){
  	  return RandomStringUtils.randomAlphabetic(length);
  	 }
    
    /**
     * This method is to generate random emails
     * @return
     */
    public static String getEmailString() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder emailsalt = new StringBuilder();
        Random rnd = new Random();
        while (emailsalt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            emailsalt.append(CHARS.charAt(index));
        }
        String emailSaltStr = emailsalt.toString();
        return emailSaltStr;

    }
    
    public static String generateRandomPassword(){
        StringBuffer randPass = new StringBuffer();
        char ch;
        for(int i=0; i<PASSWORD_LENGTH; i++){
            if(randPass.length() < PASSWORD_LENGTH )
            {
                ch = CHAR_L.charAt(getRandomNumber(CHAR_L.length()));
                 randPass.append(ch);
            }
            if(randPass.length() < PASSWORD_LENGTH )
            {
                 ch = CHAR_U.charAt(getRandomNumber(CHAR_U.length()));
                 randPass.append(ch);
            }
            if(randPass.length() < PASSWORD_LENGTH )
            {
                 ch = NUM.charAt(getRandomNumber(NUM.length()));
                 randPass.append(ch);
            }
            if(randPass.length() < PASSWORD_LENGTH )
            {
                 ch = CHAR_S.charAt(getRandomNumber(CHAR_S.length()));
                 randPass.append(ch);
            }
        }
        return randPass.toString();
     }
     private static int getRandomNumber(int index) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(index-1);
        return randomInt;
     }

}
