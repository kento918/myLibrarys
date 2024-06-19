package easyAnnotation.annotation.Main;

import java.util.Arrays;

import easyAnnotation.annotation.addStringArray;
import service.GetStringArray;


@addStringArray({"taro", "hanako"})
public class Main {
	
	@addStringArray({"takesi", "tanaka"})
	static String[] names;
	
	@addStringArray({"tuji", "tatibana"})
	public static void main(String[] args) {
		GetStringArray gsa = new GetStringArray();
		System.out.println(Arrays.deepToString(gsa.getClassAnnotationString()));
		System.out.println(Arrays.deepToString(gsa.getMethodAnnotationString()));
		gsa.createFieldAnnotationStringNonString();
		System.out.println(Arrays.deepToString(names));
		samples();
		Sample s = new Sample();
	}
	
	@addStringArray({"miturugi", "akari"})
	public static void samples() {
		GetStringArray g = new GetStringArray();
		System.out.println(Arrays.deepToString(g.getMethodAnnotationString()));
	}
}

class Sample{
	@addStringArray({"tanaka", "satou"})
	String[] something;
	
	public Sample() {
		
		@addStringArray({"taro", "tanaka"})
		String[] names;
		GetStringArray g = new GetStringArray();
		g.createFieldAnnotationStringStatic(this);
		System.out.println(Arrays.deepToString(something));
	}
	
}