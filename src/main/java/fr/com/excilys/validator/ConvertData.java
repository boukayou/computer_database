 package fr.com.excilys.validator;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

public class ConvertData {
	
	public static Optional<LocalDate> timestampToLocalDate(Timestamp timestamp) {
		LocalDate localdate = null;
		if(timestamp !=null) {
			localdate= timestamp.toLocalDateTime().toLocalDate();
			return Optional.of(localdate);
		}else {
			return Optional.ofNullable(localdate);
		}
	}	
}
