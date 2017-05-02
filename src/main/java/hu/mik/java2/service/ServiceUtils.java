package hu.mik.java2.service;

public class ServiceUtils {
	public static BookService getBookService() {
<<<<<<< HEAD
//		return new BookServiceDummyImpl();
=======
		//return new BookServiceDummyImpl();
>>>>>>> remotes/origin/master
		return new BookServiceNativeDbImpl();
	}
}
