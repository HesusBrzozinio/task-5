package pl.kb.lookup;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.BookServiceRemote;

public class EJBClient {
	/**
	 * Find remote bean and invoke business logic.
	 * 
	 * @param args
	 *            additional invocation parameters
	 * @author kamil.brzozowski 2013-05-15
	 */
	public static void main(final String[] args) {
		
	}

	/**
	 * Lookup for remote EJB.
	 * 
	 * @return EJB remote interface
	 * @author kamil.brzozowski 2013-05-15
	 */
	private static BookServiceRemote doLookup() {
		BookServiceRemote bean = null;
		try {
			// 1. Obtaining Context
			final Context context = getInitialContext();
			// 2. Lookup and cast
			bean = () context.lookup();

		} catch (final NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public static Context getInitialContext() throws NamingException {

		final Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		properties.put("jboss.naming.client.ejb.context", true);

		return new InitialContext(properties);
	}
}
