package com.taikang;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class TestS {
		public static void main(String[] args) {
			 Random RANDOM = new SecureRandom();
			    byte[] salt = new byte[16];
			    RANDOM.nextBytes(salt);
			    String str=null;
				try {
					str = new String(salt,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println(salt);
		}
}
