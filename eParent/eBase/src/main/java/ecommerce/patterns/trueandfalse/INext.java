package ecommerce.patterns.trueandfalse;

import java.util.List;

public interface INext {
	
	boolean go2First(List<Boolean> result, int length, int current);
}
