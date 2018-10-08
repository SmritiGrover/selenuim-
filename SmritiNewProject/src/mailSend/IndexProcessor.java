package mailSend;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

	public class IndexProcessor implements ServletContextListener {

	    private static final Logger LOGGER = LoggerFactory.getLogger(SearchEngineContextListener.class);

	    private Thread thread = null;
	    public void contextInitialized1(ServletContextEvent event) {
	        thread = new Thread();
	        LOGGER.debug("Starting thread: " + thread);
	        thread.start();
	        LOGGER.debug("Background process successfully started.");
	    }
	    public void contextDestroyed1(ServletContextEvent event) {
	        LOGGER.debug("Stopping thread: " + thread);
	        if (thread != null) {
	            thread.interrupt();
	            LOGGER.debug("Thread successfully stopped.");
	        }
	    }
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			
			
		}
		@Override
		public void contextInitialized(ServletContextEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
	}
