package com.douwan.ane;
/**
 * @author Rect 2013-3-14
 */


import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class DouwanExtension implements FREExtension {

	@Override
	public FREContext createContext(String arg0) {
		// TODO Auto-generated method stub
		return new DouwanContext();
	}

	@Override
	public void dispose() { 
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

}
