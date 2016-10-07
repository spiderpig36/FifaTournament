package service;

import java.text.SimpleDateFormat;

import org.glassfish.jersey.server.ResourceConfig;

public class BaseService extends ResourceConfig {
	protected static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
}
