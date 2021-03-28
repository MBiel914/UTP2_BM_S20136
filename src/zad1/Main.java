/**
 *
 *  @author Bielecki Michał S20136
 *
 */

package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
	Function<Path, List<String>> flines = p -> {
		try {
			return Files.lines(p).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	};
	
	Function<List<String>, String> join = l -> {
		StringBuffer result = new StringBuffer();;
		for(String line : l)
			result.append(line);
		return result.toString();
	};
	
	Function<String, List<Integer>> collectInts = s -> {
		return Arrays.stream(s.replaceAll("[^0-9]+", " ").substring(1).split(" ")).map(Integer::parseInt).collect(Collectors.toList());
	};
	
	Function<List<Integer>, Integer> sum = l -> {
		int result = 0;
		for(int item : l)
			result += item;
		return result;
	};
	
    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

//    List<String> arglist = Arrays.asList(args);
//    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
//    sumints = slistConv.convertBy(join, collectInts, sum);
//    System.out.println(sumints);

  }
}
