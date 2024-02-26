package tasksrunner;

public enum SingleTonEnums{
	Instance;
	
	public void printmessage() {
		System.out.println("Inside SingleTon Enums,Singleton is used to crete a single instance and can access it globaly");
	}
}

//class Example{
//private static singletonInstance instance;
//private singletonInstance() {
//	
//}
//public static Example getInstance() {
//    if (instance == null) {
//        instance = new Example();
//    }
//    return instance;
// }
//}

//class Example{
//private static singletonInstance instance;
//private singletonInstance() {
//	
//}
//public static synchronized Example getInstance() {
//  if (instance == null) {
//      instance = new Example();
//  }
//  return instance;
//}
//}

//class Example{
//private static singletonInstance instance;
//private singletonInstance() {
//	
//}
//public static Example getInstance() {
//if (instance == null) {
//	synchronized(Example.class)
//	{
//		if (instance == null) {
//   	 instance = new Example();
//	}
//}
//}
//return instance;
//}
//}