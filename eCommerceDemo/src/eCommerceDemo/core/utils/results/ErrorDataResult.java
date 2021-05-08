package eCommerceDemo.core.utils.results;

public class ErrorDataResult<T> extends DataResult<T> {
	public ErrorDataResult(T data, boolean success,String message) {
		super(data, false,message);
		
	}
	
	public ErrorDataResult(T data, boolean success) {
		super(data, false);
		
	}
}
