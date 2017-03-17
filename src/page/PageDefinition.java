package page;

import java.io.Serializable;

abstract class PageDefinition implements Serializable {
	
	private final String ROOT = "/magicOnline/view/";
	private final String XHTML = ".xhtml";
	
	public abstract String getPageName();

	public String getSimpleUrl() {
		return ROOT + getPageName() + XHTML;
	}
	
}
