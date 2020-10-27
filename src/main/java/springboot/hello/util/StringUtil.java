package springboot.hello.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	
	/**
	 * 切割字符串为数组
	 * @return
	 */
	public static String[] splitUniq(String str , String regx) {
		if(AssertUtil.isNull(str)) {
			List<String> arrlist = new ArrayList<String>();
			String[] split = str.split(regx);
				for (String string2 : split) {
					if(arrlist.contains(string2)) {
						continue;
					}
					arrlist.add(string2);
				}
			return arrlist.toArray(new String[arrlist.size()]);
		}
		return new String[] {};
	}
	
	
	/**
	 * 切割字符串为数组
	 * @return
	 */
	public static String[] split(String str , String regx) {
		if(AssertUtil.isNull(str)) {
			List<String> arrlist = new ArrayList<String>();
			String[] split = str.split(regx);
			for (String string2 : split) {
				arrlist.add(string2);
			}
			return arrlist.toArray(new String[arrlist.size()]);
		}
		return new String[] {};
	}
	
	public static void main(String[] args) {
		String s = "a,a,a,b,b,c";
		String[] splitUniq = StringUtil.splitUniq(s,",");
		for (String string : splitUniq) {
			System.out.print(string + ",");
		}
	}
//	

}
