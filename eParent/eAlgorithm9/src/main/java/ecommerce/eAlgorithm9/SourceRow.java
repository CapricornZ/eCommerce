package ecommerce.eAlgorithm9;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecommerce.base.IRow;
import ecommerce.base.ISourceRow;

public class SourceRow implements ISourceRow {
	
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

	@Override
	public void print() {
		
		char[] array=this.source.toCharArray();
		char last = array[0];
		int i=1, maxColumn=0;
		List<char[]> matrix = new ArrayList<char[]>();
		StringBuilder sb = new StringBuilder();sb.append(last);
		while(i<array.length){
			if(array[i] != last){
				
				char[] column = sb.toString().toCharArray();
				matrix.add(column);
				maxColumn = maxColumn>column.length?maxColumn:column.length;
				
				last = array[i];
				sb = new StringBuilder();sb.append(last);
			} else
				sb.append(last);
			i++;
		}
		
		char[] column = sb.toString().toCharArray();
		matrix.add(column);
		maxColumn = maxColumn>column.length?maxColumn:column.length;
		
		for(i=0; i<maxColumn; i++){
			for(char[] columnLine : matrix)
				logger.info("{}", columnLine.length>i?columnLine[i]:' ');
			logger.info("\r\n");
		}
	}
}
