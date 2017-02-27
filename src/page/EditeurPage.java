package page;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class EditeurPage implements PageDefinition {

	@Override
	public String getSimpleUrl() {
		return "/magicOnline/view/editeur.xhtml";
	}

}
