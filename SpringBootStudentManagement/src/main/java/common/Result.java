package common;

public class Result<T> {
	private Integer code;
	private String message;
	private T data;

	public Result(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static <T> Result<T> success() {
		return new Result<T>(20000, "sucess", null);
	}

	public static <T> Result<T> success(T data) {
		return new Result<T>(20000, "sucess", data);
	}

	public static <T> Result<T> success(T data, String message) {
		return new Result<T>(20000, message, data);
	}

	public static <T> Result<T> success(String message) {
		return new Result<T>(20000, message, null);
	}

	public static <T> Result<T> fail() {
		return new Result<T>(20001, "fail", null);
	}

	public static <T> Result<T> fail(Integer code) {
		return new Result<T>(code, "fail", null);
	}

	public static <T> Result<T> fail(Integer code, String message) {
		return new Result<T>(code, message, null);
	}

	public static <T> Result<T> fail(String message) {
		return new Result<T>(20001, message, null);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
