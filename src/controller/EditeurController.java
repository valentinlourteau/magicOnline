package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import game.socket.ClientEndPoint;
import service.ClientProviderService;

@Named
@ViewScoped
public class EditeurController implements Serializable {
	
	@Inject
	ClientProviderService clientProviderService;

	public void initView() {
	}
	
}
