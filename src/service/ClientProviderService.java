package service;

import javax.ejb.Local;

import game.socket.ClientEndPoint;

@Local
public interface ClientProviderService {
	
	public ClientEndPoint getClient();

}
