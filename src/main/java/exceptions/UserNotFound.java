package exceptions;

public class UserNotFound extends RuntimeException {

	public UserNotFound(Long user_id) {
		super(String.join(" ", String.valueOf(user_id), "is not a valid user id."));
		
	}
}

