package service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import easyAnnotation.annotation.addStringArray;

public class GetStringArray {
	String[] classAnnotationString;
	String[] methodAnnotationString;

	public GetStringArray() {
		setClassAnnotationString(createClassAnnotationString());
		setMethodAnnotationString(createMethodAnnotationString());
		
	}

	/**
	 * インスタンス作成時にフィールドについている
	 * アノテーションから数値を取得する
	 * static用
	 */
	public void createFieldAnnotationStringNonString() {
		StackTraceElement[] ele = new Throwable().getStackTrace();
		int eles = getIntForField(ele);
		StackTraceElement targetele = ele[eles];
		try {
			Field[] targetField = Class.forName(targetele.getClassName()).getDeclaredFields();
			for (Field f : targetField) {
				if (f != null) {
					Annotation[] ano = f.getDeclaredAnnotations();
					for (Annotation anno : ano) {
						try {
							f.setAccessible(true);
							f.set(f, ((addStringArray) anno).value());
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * インスタンス作成時にフィールドについている
	 * アノテーションから数値を取得する
	 * non-static用
	 * インスタンス作成後に作成したインスタンスのフィールドに
	 * 入力する必要がある為(と理解している（曖昧）)
	 * 
	 */
	public void createFieldAnnotationStringStatic(Object obj) {
		StackTraceElement[] ele = new Throwable().getStackTrace();
		int eles = getIntForField(ele);
		StackTraceElement targetele = ele[eles];
		try {
			Field[] targetField = Class.forName(targetele.getClassName()).getDeclaredFields();
			for (Field f : targetField) {
				if (f != null) {
					Annotation[] ano = f.getDeclaredAnnotations();
					for (Annotation anno : ano) {
						try {
							f.setAccessible(true);
							f.set(obj, ((addStringArray) anno).value());
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  インスタンス作成時にクラスについている
	 *  アノテーションから数値を取得する
	 * @return
	 * 		String[]
	 */
	private String[] createClassAnnotationString() {
		StackTraceElement[] elements = new Throwable().getStackTrace();
		int eles = getIntForElement(elements);
		StackTraceElement targetElement = elements[eles];
		try {
			Annotation[] targetAnnotations = Class.forName(targetElement.getClassName()).getAnnotations();
			for (Annotation t : targetAnnotations) {
				if (t.toString().contains("easyAnnotation.annotation.addStringArray")) {
					return ((addStringArray) t).value();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * StackTraceElementからGetStringArray.<init>
	 * の次の数値を取得
	 * 
	 * @param 
	 * 		elements
	 * @return
	 * 		int
	 */
	private int getIntForElement(StackTraceElement[] elements) {
		int index = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].toString().contains("service.GetStringArray.<init>")) {
				index = i + 1;
				return index;
			}
		}
		return index;
	}

	/**
	 * StackTraceElementからGetStringArray.<init>
	 * の次の数値を取得(Field用)
	 * 
	 * @param 
	 * 		elements
	 * @return
	 * 		int
	 */
	private int getIntForField(StackTraceElement[] elements) {
		int index = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].toString().contains("service.GetStringArray.createFieldAnnotationString")) {
				index = i + 1;
				return index;
			}
		}
		return index;
	}

	/**
	 *  インスタンス作成時のメソッドに付いている
	 *  アノテーションから数値を取得する。
	 * 
	 * @return
	 * 		String[]
	 */
	private String[] createMethodAnnotationString() {
		StackTraceElement[] elements = new Throwable().getStackTrace();
		int eles = getIntForElement(elements);
		StackTraceElement targetElement = elements[eles];
		try {
			Method[] targetMethods = Class.forName(targetElement.getClassName())
					.getDeclaredMethods();
			for (Method m : targetMethods) {
				if (m.toString().contains(targetElement.getMethodName())) {
					Annotation[] anno = m.getAnnotations();
					for (Annotation a : anno) {
						if (a.toString().contains("easyAnnotation.annotation.addStringArray")) {
							return ((addStringArray) a).value();
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* -- Getter -- Setter -- */
	public String[] getClassAnnotationString() {
		return classAnnotationString;
	}

	public void setClassAnnotationString(String[] classAnnotationString) {
		this.classAnnotationString = classAnnotationString;
	}

	public String[] getMethodAnnotationString() {
		return methodAnnotationString;
	}

	public void setMethodAnnotationString(String[] methodAnnotationString) {
		this.methodAnnotationString = methodAnnotationString;
	}

}
