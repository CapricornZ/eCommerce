package ecommerce.eAlgorithm10;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecommerce.base.ITrueAndFalse;
import ecommerce.patterns.trueandfalse.alg10.Next;

public class TrueAndFalse implements ITrueAndFalse {
	
	private static final Logger logger = LoggerFactory.getLogger(TrueAndFalse.class);
	private static int[] metaData = new int[] { 1, 2, 3, 5, 8, 13, 21, 34,
		55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946,
		17711, 28657, 46368 };
	
	private List<Boolean> result;
	public TrueAndFalse(List<Boolean> result){
		this.result = result;
	}
	
	public void print(){
		
		StringBuilder sBuild = new StringBuilder();
		this.countTrue = 0;
		this.countFalse = 0;
		for(Boolean o:this.result){
			if(o){
				countTrue ++;
				sBuild.append("o");
			} else {
				countFalse ++;
				sBuild.append("x");
			}
		}
		this.strValue = sBuild.toString();
		
		//logger.info("{}", this.strValue);
		
		logger.info(" [ x:{} ({}%), o:{} ({}%) ]\r\n", 
				countFalse, ((float)countFalse*100/(float)(countFalse+countTrue)), 
				countTrue, ((float)countTrue*100/(float)(countFalse+countTrue)));
	}
	
	public void run(int offset){
		
		this.max = 0;
		this.sum = 0;
		int indexSourceStep3 = 0;
		boolean stop = false;
		for (int indexSource = offset; !stop && indexSource < result.size(); indexSource++) {
			
			int current = metaData[indexSourceStep3];
			if(max < current)//记录最大值
				max = current;

			int delta = 0;
			if (result.get(indexSource)) {
				sum += metaData[indexSourceStep3];
				delta = metaData[indexSourceStep3];
				logger.info("+{}", metaData[indexSourceStep3]);
				if (indexSourceStep3 != 0)
					indexSourceStep3 -= 1;
			} else {
				sum -= metaData[indexSourceStep3];
				delta = -metaData[indexSourceStep3];
				logger.info("-{}", metaData[indexSourceStep3]);
				indexSourceStep3 += 1;
			}
			
			if(Next.go2First(result, indexSource+1, current))
				indexSourceStep3 = 0;
			
			if(sum >= 8 || delta == -13)
				stop = true;
		}
		logger.info(" = {} [ MAX: {} ]\r\n", sum, max);

	}
	
	private int sum, max;
	private int countTrue, countFalse;
	private String strValue;
	
	public int getSum(){return sum;}
	public int getMax(){return max;}
	public int getCountTrue(){return countTrue;}
	public int getCountFalse(){return countFalse;}
	public List<Boolean> getResult(){return this.result;}

}
