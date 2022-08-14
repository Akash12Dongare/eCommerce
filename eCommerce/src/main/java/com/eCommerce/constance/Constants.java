/**
 * 
 */
package com.eCommerce.constance;

/**
 * @author Akash.d
 *
 */
public class Constants {

	public static final String TOKEN_SECRET = "JAVA@123";
	public static final Integer TOKEN_EXPIRY = 1000 * 60 * 60 * 10;
	public final static String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	public final static String PASSWORD_MSG = "1.Password must contain at least one digit [0-9]  2.Password must contain at least one lowercase Latin character [a-z]  3.Password must contain at least one uppercase Latin character [A-Z]  4.Password must contain at least one special character like ! @ # & ( )  5.Password must contain a length of at least 8 characters and a maximum of 20 characters";
	public final static String SUCCESS = "success";
	public final static String ERROR = "error";
}
