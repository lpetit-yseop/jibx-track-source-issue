
package org.jibx.starter;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.ITrackSource;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.junit.Test;


public class TestTrackSource {
	private static final String INPUT_FILE="/data.xml";
	
	@Test
	public void testTrackSource() throws JiBXException, FileNotFoundException {
		IBindingFactory bfact = BindingDirectory.getFactory(Customer.class);
        IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
        InputStream in = this.getClass().getResourceAsStream(INPUT_FILE);
        Customer customer = (Customer)uctx.unmarshalDocument(in, null);
        
        assertTrue(customer instanceof ITrackSource);
	}
}