package ecommerce.base;

import java.util.List;

public interface ITrueAndFalse {
	
	void print();	
	void run(int offset);
	
	int getSum();
	int getMax();
	int getCountTrue();
	int getCountFalse();
	List<Boolean> getResult();

}
