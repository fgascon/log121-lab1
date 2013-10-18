package lab1.collections.comparators;

import lab1.collections.Comparator;
import lab1.formes.AbstractForme;

public class WidthComparator implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		if(obj1 instanceof AbstractForme && obj2 instanceof AbstractForme) {
			AbstractForme forme1 = (AbstractForme) obj1;
			AbstractForme forme2 = (AbstractForme) obj2;
			return (int) Math.signum(forme2.getSize().getX() - forme1.getSize().getX());
		} else {
			return 0;
		}
	}
}
