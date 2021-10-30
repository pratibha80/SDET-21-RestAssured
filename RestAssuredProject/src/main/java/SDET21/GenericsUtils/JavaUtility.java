package SDET21.GenericsUtils;

import java.util.Random;
/**
 * This class has generic methods related java library
 * @author Pratibha
 *
 */

public class JavaUtility {
	public int getRandomNumber()
	{
		Random ran=new Random();
		int random = ran.nextInt();
		return random;
	}

}
