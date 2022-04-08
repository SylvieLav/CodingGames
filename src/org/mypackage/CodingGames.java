package org.mypackage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CodingGames {
	//SELECT DISTINCT c_id FROM c INNER JOIN po ON po.c_id = c.c_id INNER JOIN op ON op.o_id = po.o_id 
	//INNER JOIN p ON p.p_id = op.p_id INNER JOIN pc ON pc.pc_id = p.pc_id WHERE pc.n IN ('Garden', 'Books')))");
	static Change change = new Change();
	
	public static void main(String[] args) {
		
	}
	
	//Coding game #1
	public static char getCharFromAscii(String s) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVQXYZ";
		char reponse = '?';
		for (char c : letters.toCharArray()) {
			if (s.equals(getAsciiFromChar(c))) {
				reponse = c;
				break;
			}
		}
		return reponse;
	}
	
	public static String getAsciiFromChar(char c) {
		return String.valueOf(c);
	}
	
	//Coding game #2
	public static Change giveChange(long s) {
		if (s<=1 || s == 3) {
			return null;
		}
		
		change.bill10 = s/10;
		s = s-10*change.bill10;
		if (s == 1 || s == 3) {
			s = s+10;
			change.bill10--;
		}
		if (s%2 != 0) {
			s = s-5;
			change.bill5 = 1;
		}
		change.coin2 = s/2;
		
		return change;
	}
	
	//Coding game #3
	public static int luckyMoney(int money, int giftees) {
		int luckyGifts = 0;
		while(money-8>=giftees-1 && !(money == 12 && giftees == 2) && giftees>0) {
			money -= 8;
			giftees--;
			luckyGifts++;
		}
		return luckyGifts;
	}
}