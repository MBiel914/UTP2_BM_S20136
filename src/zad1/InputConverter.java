package zad1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {
	Path _Path;
	public InputConverter(T input) {
		_Path = Paths.get((String)input);
	}
	
	public List<T> convertBy(Function<Path, List<T>> inputFunction){		
		return inputFunction.apply(_Path);
	}
}
