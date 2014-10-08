package cs441.eews.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vimalkumar Patel
 * 
 */
public class EpidemicProbability {

	private static Map<Integer, Double> RegionEP = new HashMap<Integer, Double>();
	private static Map<Integer, Integer> RegionCount = new HashMap<Integer, Integer>();

	public static Map<Integer, Double> getRegionEP() {
		return RegionEP;
	}

	public static void setRegionEP(Map<Integer, Double> regionEP) {
		RegionEP = regionEP;
	}

	public static Map<Integer, Integer> getRegionCount() {
		return RegionCount;
	}

	public static void setRegionCount(Map<Integer, Integer> regionCount) {
		RegionCount = regionCount;
	}

	public static synchronized void updateEP(int regionID, Double ep) {

		Integer count = 0;
		Double p = 0.0;

		if (null == RegionCount.get(regionID)) {
			RegionCount.put(regionID, count);
		} else {
			count = RegionCount.get(regionID);
		}

		if (null == RegionEP.get(regionID)) {
			RegionEP.put(regionID, p);
		} else {
			p = RegionEP.get(regionID);
		}

		count++;
		if (ep < 0) {
			ep = ep * ep;
		}
		if (ep > 1) {
			do {
				ep = ep / 100;
			} while (ep > 1);
		}
		p = ((p * count - 1) + ep) / count;
		if (p > 1) {
			do {
				p = p / 10;
			} while (p > 1);
		}

		RegionEP.put(regionID, p);
		RegionCount.put(regionID, count);

	}

}
