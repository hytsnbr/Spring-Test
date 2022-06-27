package com.hytsnbr.demo.util.date.converter;

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LocalDateConverterTest {
	
	private LocalDateConverter localDateConverter;
	
	@BeforeEach
	void setUp() {
		localDateConverter = new LocalDateConverter();
	}
	
	@Test
	void fromString() {
		LocalDate expected = LocalDate.of(2022, 4, 1);
		
		try {
			LocalDate actual = localDateConverter.fromString("2022/04/01", "yyyy/MM/dd");
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	void fromEpochTime() {
		final long nowEpoch = Calendar.getInstance().getTimeInMillis();
	}
	
	@Test
	void toUtilDate() {
	}
	
	@Test
	void toSqlDate() {
	}
	
	@Test
	void toTimeStamp() {
	}
	
	@Test
	void toLocalDate() {
	}
	
	@Test
	void toLocalDateTime() {
	}
}