package de.heikostumpf.aws.ec2.info;

import de.heikostumpf.aws.ec2.info.EC2InstanceInfoApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EC2InstanceInfoApplication.class);
	}

}
