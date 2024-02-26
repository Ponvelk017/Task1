package tasksrunner;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.JsonExample;
import task.Serialization;

public class TaskRunner {

	private static Logger logger = Logger.getLogger(CircleRunner.class.getName());

	public static TaskRunner tasks = new TaskRunner();

	public static void main(String[] args) {
		
		
		Console console = System.console();
		if(console != null) {
		char pass[]=console.readPassword("Enter");
		String s = new String(pass);
		System.out.println(s);
		}
		

		StringBuilderRunner runner2 = new StringBuilderRunner(); 
//         runner2.taskRunner();
		InheritanceRunner runnner3 = new InheritanceRunner();
//        // runnner3.taskRunner();
		ArrayListRunner runner4 = new ArrayListRunner();
//        runner4.taskRunner();
		HashMapRunner runner5 = new HashMapRunner();
//        runner5.taskRunner();
		BasicProgrammingRunner runner6 = new BasicProgrammingRunner();
//        runner6.taskrunner();
		BasicPrg_AdditionalConstructorRunner runner7 = new BasicPrg_AdditionalConstructorRunner();
//        runner7.taskTunner();
		CircleRunner runner8 = new CircleRunner();
//        runner8.taskRunner();
		Basicprg_ReflectionRunner runner9 = new Basicprg_ReflectionRunner();
//        runner9.taskRunner();
		EnumsRunner runner10 = new EnumsRunner();
//        Rainbow allColors[] = runner10.taskRunner();
//        for(Rainbow singleColor : allColors) {
//        	logger.info("Individual Colors are : " + singleColor +"Ordinal : "+singleColor.ordinal());
//        }
//        SingleTonEnums.Instance.printmessage();
		DateTimeRunner runner12 = new DateTimeRunner();
//        runner12.taskRunner();
		ThreadClassRunner runner13 = new ThreadClassRunner();
//        runner13.taskRunner();
		DataBaseTaskRunner runner15 = new DataBaseTaskRunner();
//		try {
//			runner15.taskRuner();
			SerializationRunner runner16 = new SerializationRunner();
			JsonRunner runner17 = new JsonRunner();
			runner17.taskRunner();
//			runner16.taskRunner();
//		} catch (InvalidInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			RegxTaskRunner runner14 = new RegxTaskRunner();
//			runner14.taskRunner();
//             logger.info("String read using command line args : " +args[0]);
             Scanner sc = new Scanner(System.in);
//             logger.info("Enter the String : ");
//             String input = sc.next();
//             StringTask task = new StringTask();
//             logger.info("Length of the Given stirng : " + task.findLength(input));
//             logger.info("The Converted Array Using String : ");
//             char charArray[] = task.characterArray(input);
//             for(char ch : charArray)System.out.print(ch+" ");
//             logger.info();
//             logger.info("Enter the position of the character to find : ");
//             logger.info("The Last but one place Character : " +
//             task.penultimate(input , sc.nextInt()));
//             logger.info("Enter the character to find occurance : ");
//             logger.info("The number of occurance of the given character : " +
//             task.findOccurance(input,sc.next().charAt(0)));
//             logger.info("Enter the character to find greatest position : ");
//             logger.info("The Greatest Position of the given cahracter : " +
//             task.greatestPosition(input,sc.next().charAt(0)));
//             logger.info("Enter the Position to find last N character : ");
//             logger.info("The Last N Character of the Given stirng : " +
//             task.LastNChar(input , sc.nextInt()));
//             logger.info("Enter the Position to find First N character : ");
//             logger.info("The First N character of the Given stirng : " +
//             task.firstNChar(input , sc.nextInt()));
//             logger.info("Enter the String to replace and getreplaced : ");
//             //logger.info("The String after Replacing first N character with : " +
//             //task.replacingString(input,sc.next(),sc.nextInt(),sc.next()));
//             logger.info("Enter the String to to find whether it start with : ");
//             logger.info("Does the Stirng starts with : " +
//             (task.startingWith(input ,sc.next()) ? "Yes" : "No"));
//             logger.info("Enter the String to to find whether it ends with : ");
//             logger.info("Does the Stirng ends with : " + (task.endingWith(input ,
//             sc.next()) ? "Yes" : "No"));
//             logger.info("Enter which case to convert :");
//             logger.info("The Uppercase of the Given stirng : " +
//             task.convertCase(input , true));
//             logger.info("Enter which case to convert :");
//             logger.info("The lowercase of the Given stirng : " +
//             task.convertCase(input , false));
//             logger.info("The reversed stirng : " + task.reversingString(input));
//             logger.info("Enter the String : ");
//             sc.nextLine();
//             String input2 = sc.nextLine();
//             logger.info("The Concatenated stirng without spaces: " +
//             task.singleString(input2," ",""));
//             System.out.print("The Multiple Stirngs are :");
//             Arrays.stream(task.multipleString(input2," ")).forEach(System.out::print);
//             logger.info();
//             logger.info("The Concatenated String with - :"+task.mergeString(input2.split(" "),"-"));
//             logger.info("Whether the given stirngs are equal(case sensitive) : " +
//             (task.stringEquals(input2, input2)));
//             logger.info("Whether the given stirngs are equal(case insensitive) : "
//             + (task.stringEqualsCaseIn(input2, input2)));
//             logger.info("The stirngs after the spaces removed : " +
//             (task.removeSpaces(input2)));
//
//		} catch (InvalidInputException e) {
//			logger.log(Level.INFO, "An Exception occured", e);
//		}
	}
}
