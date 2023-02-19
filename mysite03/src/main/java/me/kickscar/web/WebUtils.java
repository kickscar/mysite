package me.kickscar.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebUtils {
	public static String encodeURL(String url, String encode) {
		String urlEncode = null;
		try {
			urlEncode = URLEncoder.encode(url, encode);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return urlEncode;
	}
}
