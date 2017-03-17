package dao.combo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.GenericJpaDaoImpl;
import entities.Type;

@Stateless
@LocalBean
public class TypeDaoImpl extends GenericJpaDaoImpl<Type> implements TypeDao {

	@Override
	public Type findById(long id) {
		return queryFactory().selectFrom(TYPE).where(TYPE.id.eq(id)).fetchOne();
	}

	@Override
	public List<Type> findAll() {
		return queryFactory().selectFrom(TYPE).fetch();
	}

}
