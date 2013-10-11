package lab1.collections.comparators;

import java.util.Hashtable;

import lab1.collections.Comparator;
import lab1.formes.AbstractForme;

public class TypeComparator implements Comparator {
	
	private Hashtable<String, Integer> typeOrder;
	
	public TypeComparator() {
		typeOrder = new Hashtable<String, Integer>();
		typeOrder.put("carre", 1);
		typeOrder.put("rectangle", 2);
		typeOrder.put("cercle", 3);
		typeOrder.put("ovale", 4);
		typeOrder.put("ligne", 5);
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		if(obj1 instanceof AbstractForme && obj2 instanceof AbstractForme) {
			AbstractForme forme1 = (AbstractForme) obj1;
			AbstractForme forme2 = (AbstractForme) obj2;
			int forme1Order = typeOrder.get(forme1.getType());
			int forme2Order = typeOrder.get(forme2.getType());
			return (int) Math.signum(forme2Order - forme1Order);
		} else {
			return 0;
		}
	}
}
