package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {
	private T _input;
	
	public Maybe(T input) {
		if(input != null && input != "")
			_input = input;
		else
			_input = (T) "empty";
	}
	public static <T> Maybe<T> of(T input) {
		return new Maybe<T>(input);
	}
	
	public String toString() {
		return "Maybe has value " + _input.toString();
	}
	public void ifPresent(Consumer<T> cons) {
		if (_input != "empty")
			cons.accept(_input);
	}
	public Maybe map(Function<T, ?> func) {
		if (_input != null && _input != "empty")
			return new Maybe<Object>(func.apply(this._input));
		return new Maybe<Object>(_input);
	}
	public T get() {
		if (_input != null && _input != "empty")
			return _input;
		throw new NoSuchElementException("maybe is empty");
	}
	public boolean isPresent() {
		if (_input != null && _input != "empty")
			return true;
		return false;
	}
	public <T extends String> T orElse(T defVal) {
		if (_input != null && _input != "empty")
			return (T) _input;
		return (T) defVal;
	}
	public Maybe<T> filter(Predicate<T> pred) {
		if(pred.test(_input))
			return this;
		return new Maybe<T>(null);
	}
}
