package combo.provider;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;

import dao.combo.TypeDao;
import entities.Type;

@Startup
@Singleton
public class TypeProvider implements ComboProvider<Type> {
	
	@Inject
	TypeDao typeDao;
	
	private static Set<Type> types;
	static int i;

	@PostConstruct
	@Override
	public void constructCombo() {
		setTypes(new HashSet<>(typeDao.findAll()));
	}
	
	public static Set<Type> getItems(String[] libelles) {
		Set<Type> toReturn = new HashSet<>();
		for (i = 0; i < libelles.length; i++) {
			Type newType = new Type();
			newType.setLibelle(libelles[i]);
			boolean addNewType = false;
			addNewType = !types.stream().anyMatch(type -> type.getLibelle().equals(libelles[i]));
			toReturn.add(types.stream().filter(type -> type.getLibelle().equals(libelles[i])).findAny().orElse(newType));
			if (addNewType)
				types.add(newType);
		}
		return toReturn;
	}

	public static Set<Type> getTypes() {
		return types;
	}

	public static void setTypes(Set<Type> types) {
		TypeProvider.types = types;
	}

}
