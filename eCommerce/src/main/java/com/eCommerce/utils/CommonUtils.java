/**
 * 
 */
package com.eCommerce.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eCommerce.constance.Constants;

/**
 * @author Akash.d
 *
 */
public class CommonUtils {

	public static boolean passwordValidation(String password) {
		Pattern pattern = Pattern.compile(Constants.PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
