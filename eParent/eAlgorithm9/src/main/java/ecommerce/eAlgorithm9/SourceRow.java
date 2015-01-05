package ecommerce.eAlgorithm9;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecommerce.base.IRow;
import ecommerce.base.ISourceRow;

public class SourceRow extends ISourceRow {
	
	private static Logger logger = LoggerFactory.getLogger(SourceRow.class);

	private String source;
	public SourceRow(String source){
		this.source = source;
	}
	
	@Override
	public String getSource(){
		return this.source;
	}

	
	@Override
	public IRow run() {
		
		List<Element> elements = new ArrayList<Element>();
		int length = this.source.length()/7;
		int i=0;
		for(; i<length; i++){
			String sub = source.substring(i*7, i*7+7);
			elements.add(new Element(sub.toCharArray()));
		}
		String sub = source.substring(i*7, source.length());
		elements.add(new Element(sub.toCharArray()));
		return new ResultRow(elements);
	}	
}
