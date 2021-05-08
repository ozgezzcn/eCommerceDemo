package eCommerceDemo.dataAccess.abstracts;

import eCommerceDemo.core.crudOperations.EntityCrudBase;

public interface Dao<Entity extends eCommerceDemo.core.entities.Entity> extends EntityCrudBase<Entity> {

}
