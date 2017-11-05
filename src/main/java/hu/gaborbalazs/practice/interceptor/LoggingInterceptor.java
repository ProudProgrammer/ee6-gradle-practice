package hu.gaborbalazs.practice.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
@Loggable
public class LoggingInterceptor {

	private static final String ENTER = ">> ";
	private static final String EXIT = "<< ";

	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
		String className = ic.getTarget().getClass().getName().contains("$") ? ic.getTarget().getClass().getName()
				.subSequence(0, ic.getTarget().getClass().getName().indexOf("$")).toString()
				: ic.getTarget().getClass().getName();
		Logger logger = LoggerFactory.getLogger(className);
		StringBuilder builder = new StringBuilder(ENTER);
		builder.append(ic.getMethod().getName());
		builder.append("()");
		logger.trace(builder.toString());
		try {
			return ic.proceed();
		} finally {
			builder = new StringBuilder(EXIT);
			builder.append(ic.getMethod().getName());
			builder.append("()");
			logger.trace(builder.toString());
		}
	}
}
