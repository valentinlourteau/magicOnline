package page;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EditeurPage extends PageDefinition {

	@Override
	public String getPageName() {
		return "editeur";
	}

}
