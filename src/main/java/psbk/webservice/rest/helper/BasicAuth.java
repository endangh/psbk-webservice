package psbk.webservice.rest.helper;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

public class BasicAuth implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BasicAuth(HttpServletRequest servletRequest) {
		String header = servletRequest.getHeader("Authorization");
		if (header != null) {
			header = header.replaceAll("Basic ", "");

			String[] values = new String(Base64.decodeBase64(header))
					.split(":");
			if (values.length == 2) {
				username = values[0];
				password = values[1];
			}
		}
		// TODO Auto-generated constructor stub
	}
}
