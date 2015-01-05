package ecommerce.eAlgorithm10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecommerce.base.IRow;
import ecommerce.base.ISourceRow;

public class SourceRowB extends ISourceRow {
	
	private static Logger logger = LoggerFactory.getLogger(SourceRowB.class);

	private String source;	
	private IExpect pattern12, pattern5, patternB;
	public void setPatternB(IExpect patternB) {
		this.patternB = patternB;
	}

	public void setPattern12(IExpect pattern12) {
		this.pattern12 = pattern12;
	}

	public void setPattern5(IExpect pattern5) {
		this.pattern5 = pattern5;
	}

	public SourceRowB(String source){
		this.source = source;
	}
	
	@Override
	public String getSource(){
		return this.source;
	}
	
	@Override
	public IRow run() {
		
		List<ElementA> elements = new ArrayList<ElementA>();
		int length = this.source.length()/7;
		int i=0;
		for(; i<length; i++){
			String sub = source.substring(i*7, i*7+7);
			elements.add(new ElementB(sub.toCharArray(), this.pattern12, this.pattern5, this.patternB));
		}
		
		if(this.source.length()%7 != 0){
			String sub = source.substring(i*7, source.length());
			elements.add(new ElementB(sub.toCharArray(), this.pattern12, this.pattern5, this.patternB));
		}
		return new ResultRow(elements);
	}
}
