package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class EditeurController implements Serializable {

	public void initView() {
		System.out.println("je suis dans l'editeur");
	}
	
}
