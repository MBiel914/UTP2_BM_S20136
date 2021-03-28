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
	
	public List<T> convertBy(Function<Path, List<T>> getList){		
		return getList.apply(_Path);
	}
	public T convertBy(Function<Path, List<String>> getList, Function<List<T>, T> getString){		
		return getString.apply((List<T>) getList.apply(_Path));
	}
	public List<Integer> convertBy(Function<Path, List<String>> getList, Function<List<T>, T> getString, Function<T, List<Integer>> getInts){
		
		return getInts.apply(getString.apply((List<T>) getList.apply(_Path)));
	}
	public Integer convertBy(Function<Path, List<String>> getList, Function<List<T>, T> getString, Function<T, List<Integer>> getInts, Function<List<Integer>, Integer> getInt){
		
		return getInt.apply(getInts.apply(getString.apply((List<T>) getList.apply(_Path))));
	}
}
