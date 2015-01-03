package ecommerce.eAlgorithm10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecommerce.base.IResultRow;
import ecommerce.base.IRow;
import ecommerce.base.ITrueAndFalse;

public class ResultRow implements IResultRow {
	
	private static Logger logger = LoggerFactory.getLogger(ResultRow.class);

	private List<Element> data;
	public ResultRow(List<Element> data){
		this.data = data;
	}
	
	@Override
	public IRow run() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ITrueAndFalse> getResult() {
		
		List<Boolean> result = new ArrayList<Boolean>();
		for(int i=1; i<this.data.size(); i++){
			
			Element last = this.data.get(i-1);
			Element current = this.data.get(i);
			
			List<Boolean> rtn = current.execute(last);
			result.addAll(rtn);
		}
		
		List<ITrueAndFalse> rtn = new ArrayList<ITrueAndFalse>();
		rtn.add(new TrueAndFalse(result));
		return rtn;
	}

}
