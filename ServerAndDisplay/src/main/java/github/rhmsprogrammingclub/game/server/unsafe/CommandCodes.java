package github.rhmsprogrammingclub.game.server.unsafe;

import github.rhmsprogrammingclub.game.server.utils.TwoWayHashMap;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by will on 10/7/15 at 7:22 PM.
 * This is the most secure way I could think of to
 * implement server commands to start, and stop the
 * sever.
 * 
 * <p>
 * Good luck brute forcing the sha-256 encryption, Jacob.
 * 
 * @since v0.1
 * @version v0.1
 * @author Will "n9Mtq4" Bresnahan
 */
public final class CommandCodes {
	
	private static final TwoWayHashMap<String, String> codes = new TwoWayHashMap<String, String>() {{
		put("shutdown", "c8bc5cc276e5b9f9e4e1804912d703c574b3d1adbbc726fb4c4f4a67767d8f37");
		put("startgame", "4f6f32a030e689d1b3f62e188c7e3061bd2d8015b37282e67f10482a8dac92da");
	}};
	
	public static void main(String[] args) {
		String joined = "";
		for (String s : args) {
			joined += s + " ";
		}
		joined = joined.trim();
		System.out.println(encrypt(joined));
	}
	
	private CommandCodes() {
	}
	
	public static String getCode(String input) {
		return codes.getReverse(encrypt(input));
	}
	
	private static boolean check(String input, String sha) {
		return encrypt(input).equals(sha);
	}
	
	private static String encrypt(String str) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes("UTF-8"));
			byte[] digest = md.digest();
			return String.format("%064x", new java.math.BigInteger(1, digest));
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return String.format("%064x", new java.math.BigInteger(1, new byte[]{-1}));
		
	}
	
}
