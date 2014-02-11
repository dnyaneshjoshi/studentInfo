package org.iiitb.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticateInterceptor implements Interceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2799348281841811478L;

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{

		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

		if (session.get("user") == null)
		{
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}

}
