package service;

import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import game.socket.ClientEndPoint;
import singleton.ChannelProvider;

@LocalBean
@Stateless
public class ClientProviderServiceImpl implements ClientProviderService {

	@Override
	public ClientEndPoint getClient() {
		return new ClientEndPoint(URI.create(ChannelProvider.getUri()));
	}

}
