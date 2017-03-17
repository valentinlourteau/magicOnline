package dao.combo;

import javax.ejb.Local;

import dao.GenericJpaDao;
import entities.Type;

@Local
public interface TypeDao extends GenericJpaDao<Type> {

}
