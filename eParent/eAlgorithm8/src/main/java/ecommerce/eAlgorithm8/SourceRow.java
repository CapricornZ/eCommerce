package ecommerce.eAlgorithm8;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecommerce.base.Decide;
import ecommerce.base.IRow;

public class SourceRow implements IRow{
	
private static Logger logger = LoggerFactory.getLogger(SourceRow.class);
	
	private String source;
	public SourceRow(String source){
		this.source = source;
	}
	
	@Override
	public IRow run() {
		
		List<Decide> result = new ArrayList<Decide>();
		String row = source.length()>40?source.substring(0,40):source;
		for(int i=11; i<row.length(); i++){
			String val = source.substring(i-11, i+1);
			logger.debug(val);
			Decide rtn = new Element(val).execute();
			logger.debug("{}\r\n", rtn.getVal());
			result.add(rtn);
		}
		
		return new ResultRow(result);
	}
	@Override
	public void print() {
		logger.info("{} {}\r\n", this.source, this.source.length()>40?"(>40)":"");
	}

}
