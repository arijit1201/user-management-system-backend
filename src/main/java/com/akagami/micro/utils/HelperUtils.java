package com.akagami.micro.utils;



import java.util.logging.Logger;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Component
public class HelperUtils {
//	private static final Logger logger 
//	  = LoggerFactory.getLogger(HelperUtils.class);
	public static void copyProperties(Object src, Object trg, Iterable<String> props) {
		try {
			BeanWrapper srcWrap = PropertyAccessorFactory.forBeanPropertyAccess(src);
		    BeanWrapper trgWrap = PropertyAccessorFactory.forBeanPropertyAccess(trg);
		    props.forEach(p -> trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p)));
		}
	    catch (PropertyAccessException e) {
			// TODO: handle exception
//	    	logger.error(e.getMessage());
	    	StackTraceElement[] stackTraceElements = e.getStackTrace();
	    	for(StackTraceElement el: stackTraceElements)
	    		System.out.println(el.toString());

	    	
		}

	}
}
