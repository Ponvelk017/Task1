package tasksrunner;
import task.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;

public class StringBuilderRunner {
	private Logger logger = Logger.getLogger(StringBuilderRunner.class.getName());
	
    public void taskRunner() {
        try {
            StringBuilderTask task4 = new StringBuilderTask();
            StringBuilder sb = task4.createStringBuilder();
            String array[] = {"hello","head","first","java"};
            for(int i =0 ;i < array.length;i++){
                sb = task4.append(sb, array[i]);
                sb.append(" ");
            }
            logger.info("The length of a empty StringBuilder : " + task4.findLength(new StringBuilder()));
            logger.info("The length of a StringBuilder with a string : " + task4.findLength(new StringBuilder("Hello")));
            logger.info("The length of a empty StringBuilder : " + task4.findLength(new StringBuilder()));
            logger.info("The StringBuilder after adding four Strings : "+ sb);
            logger.info("The Inserting another String inbetween with spaces : " + task4.appendStringAtPosition(sb,"hello",10));
            logger.info("The StringBuilder is : " + sb);
            logger.info("The StirngBuilder after deleting hello : " + task4.deleteInStringBuilder(sb ,0, 5));
            logger.info("The StringBuilder after replacin space with - : "+ task4.replaceUsingString(sb, " ", "-"));
            logger.info("The StringBuilder after replacin head with - : "+ task4.replaceUsingIndex(sb,"#",0,5));
            logger.info("The reversed StringBuilder : " + task4.reverseInStringBuilder(sb));
            logger.info("The StringBuilder with 10 chars : " + task4.createStringBuilder("hello java"));
            logger.info("The StringBuilder after deleting chars from 6-8 : " + task4.deleteInStringBuilder(sb, 6, 8));
            logger.info("The StringBuilder after replacing chars from 6-8 : "+ task4.replaceUsingIndex(sb,"XYZ",6,8));
            logger.info("The index of 1st # is : " + task4.firstIndexInStringBuilder(task4.createStringBuilder("hello java"), "hello"));
            logger.info("The index of 1st # is : " + task4.lastIndexInStringBuilder(task4.createStringBuilder("hello java"), "java"));
        } catch (InvalidInputException e) {
        	logger.log(Level.INFO, "An Exception Occured", e);
        }
    }
}
