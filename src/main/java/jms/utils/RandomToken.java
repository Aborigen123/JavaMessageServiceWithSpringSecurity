package jms.utils;

import org.apache.commons.lang.RandomStringUtils;

public final class RandomToken {

	public static String generateRandomString() {
		String string = RandomStringUtils.randomAlphabetic(80);
		System.out.println("Rand.token"+string);
		
		return string;
	}
}
