package task;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import inputcheck.InvalidInputException;
import util.Util;

public class DateTimeTask {
	
	public LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now();
	}
	
	public long getCurrentTimeInMillSec() {
		return System.currentTimeMillis();
	}
	
	public Set<String> allZones () {
		Set<String> allZone = ZoneId.getAvailableZoneIds();
		return allZone;
	}
	
	public ZonedDateTime getZoneCurrentDateTime(String zone) throws InvalidInputException {
		Util.checkNull(zone);
		return ZonedDateTime.now(ZoneId.of(zone));
	}
	
	public DayOfWeek getDayOfWeek(ZonedDateTime time) throws InvalidInputException {
		Util.checkNull(time);
		return time.getDayOfWeek();		
	}
	
	public Month getMonth(ZonedDateTime time) throws InvalidInputException {
		Util.checkNull(time);
		return time.getMonth();		
	}
	
	public int getYear(ZonedDateTime time) throws InvalidInputException {
		Util.checkNull(time);
		return time.getYear();		
	}
}
