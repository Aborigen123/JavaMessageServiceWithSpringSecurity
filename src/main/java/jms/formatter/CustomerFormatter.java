package jms.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import jms.entity.UserEntity;


@Component
public class CustomerFormatter implements Formatter<UserEntity> {

	@Override
	public UserEntity parse(String text, Locale locale) throws ParseException {
		UserEntity customer = new UserEntity();
		customer.setId(Long.valueOf(text));
		return customer;
	}
	
	@Override
	public String print(UserEntity object, Locale locale)  {
		return String.valueOf(object.getId());
	}



}
