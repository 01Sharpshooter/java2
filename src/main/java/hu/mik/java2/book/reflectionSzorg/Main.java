package hu.mik.java2.book.reflectionSzorg;

import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) {		
		
		try {
			int valasztottId=42;
			Class cls;
			cls = Class.forName("hu.mik.java2.book.bean.Book");
			Object obj;
			Constructor constructor = cls.getConstructor();
			obj = constructor.newInstance();
			Field id=obj.getClass().getDeclaredField("id");
			id.setAccessible(true);
			id.set(obj, valasztottId);
		
			System.out.println(id.get(obj));
			
		} catch (ClassNotFoundException  | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
}
