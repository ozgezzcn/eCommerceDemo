package eCommerceDemo.business.abstracts;

import java.util.List;
import java.util.function.Predicate;

import eCommerceDemo.core.utils.results.DataResultBase;
import eCommerceDemo.core.utils.results.ResultBase;
import eCommerceDemo.entities.concretes.User;

public interface UserService {
	ResultBase add(User user);
	ResultBase update(User user);
	ResultBase delete(User user);
	DataResultBase<User> get(Predicate<User> predicate);
	DataResultBase<List<User>> getAll();
	DataResultBase<List<User>> getAll(Predicate<User> predicate);
}
