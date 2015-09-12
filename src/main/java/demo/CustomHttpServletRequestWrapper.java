package demo;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String> customHeaders;

	public CustomHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.customHeaders = new HashMap<String, String>();
	}

	public void putHeader(String name, String value) {
		this.customHeaders.put(name, value);
	}

	@Override
	public String getHeader(String name) {
		if (customHeaders.containsKey(name)) {
			return customHeaders.get(name);
		}
		return super.getHeader(name);
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		Set<String> set = new HashSet<String>(customHeaders.keySet());
		for (String name : Collections.list(super.getHeaderNames())) {
			set.add(name);
		}
		return Collections.enumeration(set);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		// TODO
		return super.getHeaders(name);
	}
}
