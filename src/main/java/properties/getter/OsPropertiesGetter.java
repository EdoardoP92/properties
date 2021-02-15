package properties.getter;

import javax.annotation.PostConstruct;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class OsPropertiesGetter implements EnvironmentAware {

	private String os;
	private String oneDrive;
	private String internalProperty;
	
	@Override
	public void setEnvironment(Environment environment) {

		this.oneDrive = environment.getProperty("OneDrive");
		this.os = environment.getProperty("OS");
		this.internalProperty = environment.getProperty("internal.property");
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("FROM OS: "+os);
		System.out.println("FROM OS: "+oneDrive);
		System.out.println("FROM OS: "+System.getenv("MAVEN_HOME"));//pure java
		System.out.println("FROM APPLICATION.PROPERTIES: "+internalProperty);
		System.out.println("FROM JVM: "+System.getProperty("java.property"));//pure java
		
//		System.out.println(System.getProperties()); //complete JVM properties as map
//		System.out.println(System.getenv()); //complete OS properties as map
	}

}
