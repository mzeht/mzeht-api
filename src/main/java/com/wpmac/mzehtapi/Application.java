package com.wpmac.mzehtapi;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	private static final Logger log = Logger.getLogger(Application.class);

	@Inject
	private Environment environment;

	/**
	 * Initializes application.
	 * <p/>
	 * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
	 * <p/>
	 */
	@PostConstruct
	public void initApplication() throws IOException {
		if (environment.getActiveProfiles().length == 0) {
			log.warn("No Spring profile configured, running with default configuration");
		} else {
			//log.info("Running with Spring profile(s) : {}", Arrays.toString(environment.getActiveProfiles()));
		}
	}

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		try {
			MDC.put("ip", InetAddress.getLocalHost().getHostAddress());
			MDC.put("appName","mzehtApi");
		} catch (UnknownHostException e) {
			log.error(e.getMessage(),e);
		}
		SpringApplication app = new SpringApplication(Application.class);

		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		addDefaultProfile(app, source);

		app.run(args);
	}

	private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
		if (!source.containsProperty("spring.profiles.active")) {
			app.setAdditionalProfiles("development");
		} else {
			app.setAdditionalProfiles(source.getProperty("spring.profiles.active"));
		}
	}


}
