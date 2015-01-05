package ecommerce.patterns.trueandfalse.alg8;

import ecommerce.base.ITrueAndFalse;
import ecommerce.patterns.trueandfalse.stop.IStop;

public class Stop implements IStop {
	
	private static IStop[] stops;
	public void setStops(IStop[] vals){
		this.stops = vals;
	}

	@Override
	public boolean match(ITrueAndFalse taf) {
		
		boolean bStop = false;
		for(int i=0; !bStop && i<this.stops.length; i++)
			bStop = this.stops[i].match(taf);
		return false;
	}
}

	