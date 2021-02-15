package properties.getter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"file:${external.properties.path}"})
public class SpringPropsGetter {

	@Autowired
	private Environment env;
	
	@PostConstruct
	public void init() {
		System.out.println(env.getProperty("OneDrive"));//OS
		System.out.println(env.getProperty("java.property"));//JVM
		System.out.println(env.getProperty("internal.property"));//APPLICATION.PROPERTIES
		System.out.println(env.getProperty("external.property"));//EXTERNAL PROPERTIES
	}
	
	public String getProperty(String propName) {
		return env.getProperty(propName);
	}
	
	@PreDestroy
	public void finish() {
		System.out.println(env.getProperty("internal.property"));//APPLICATION.PROPERTIES
		System.out.println(env.getProperty("external.property"));//EXTERNAL PROPERTIES
	}
}
