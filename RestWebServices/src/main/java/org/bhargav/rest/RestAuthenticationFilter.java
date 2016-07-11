package org.bhargav.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestAuthenticationFilter implements Filter {

	public static final String AUTHENTICATION_HEADER = "Authorization";
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		if(arg0 instanceof HttpServletRequest)
		{
			HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
			String authCredentials = httpServletRequest.getHeader(AUTHENTICATION_HEADER);
			System.out.println("authCredentials " + authCredentials);
			AuthenticationService authenticationService = new AuthenticationService();
			boolean authenticationStatus = authenticationService.authenticate(authCredentials);
            System.out.println("authenticationStatus " + authenticationStatus);
            if (authenticationStatus) {
            	arg2.doFilter(arg0, arg1);
            }
            else if (arg1 instanceof HttpServletResponse) {
            	HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
