package commonmethods;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

	/**
	 * This method is to generate random strings
	 * @param length
	 * @return
	 */
    public static String generateRandomString(int length){
  	  return RandomStringUtils.randomAlphabetic(length);
  	 }

}
