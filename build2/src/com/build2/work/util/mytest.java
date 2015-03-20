package com.build2.work.util;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import com.google.api.*;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class mytest implements Runnable {
	long time = 0;

	public mytest() {
		cn2PinYin("渣打科技营运有限公司35 China Okay");
		cn2Eng("");
	}

	private void cn2Eng(String string) {
		try{
		      String translatedText = Translate.DEFAULT.execute("Salut le monde", Language.FRENCH, Language.ENGLISH);
		      System.out.println(translatedText);
		      
		      
		    } catch (Exception ex) {
		      ex.printStackTrace();
		  }
	}

	public void checkFile() {
		try {
			File file = new File(
					"C:/temp/alm/build2/src/com/build2/work/util/a.txt");
			time = file.lastModified();
			Date d = new Date(time);
			Format simpleFormat = new SimpleDateFormat(
					"E dd MMM yyyy hh:mm:ss a");
			String dateString = simpleFormat.format(d);
			System.err.println(file.getName() + "--" + dateString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void cn2PinYin(String s) {
		String pinyinName = "";
		char[] nameChar = s.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(
							nameChar[i], defaultFormat)[0]+" ";
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		System.out.println(pinyinName);
	}

	public static void main(String args[]) throws Exception {
		mytest m = new mytest();
		m.run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// System.out
		// .println("========Start to check the modified time of the file=======");
		//
		// while(true){
		// m.checkFile();
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("Start to run/.");
	}
}
