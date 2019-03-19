package fr.com.excilys.springConf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CdbWebAppnitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	  @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return null;
	    }

	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class<?>[] { SpringConfig.class };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

}
