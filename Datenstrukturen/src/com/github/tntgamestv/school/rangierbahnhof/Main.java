/**
 * 
 */
package com.github.tntgamestv.school.rangierbahnhof;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 30-11-2017
 */
public class Main {

	public static void main(String[] args) {
		Gleis a = new Gleis("a", Gleis.ROLE_START);
		Gleis b = new Gleis("b", Gleis.ROLE_CACHE);
		Gleis c = new Gleis("c", Gleis.ROLE_END);

		a.push(new Wagon(16));
		a.push(new Wagon(11));
		a.push(new Wagon(15));
		a.push(new Wagon(14));
		
		//Alg
		execute2(a, b, c);
		
		System.out.println("Gleis A:");
		a.getContent().forEach((v) -> System.out.println(v.getId()));
		
		System.out.println("Gleis B:");
		b.getContent().forEach((v) -> System.out.println(v.getId()));
		
		System.out.println("Gleis C:");
		c.getContent().forEach((v) -> System.out.println(v.getId()));
	}
	
	private static void execute2(Gleis x, Gleis y, Gleis z) {
		Gleis a = x.getRole() == Gleis.ROLE_START ? x : y.getRole() == Gleis.ROLE_START ? y : z;
		Gleis b = x.getRole() == Gleis.ROLE_CACHE ? x : y.getRole() == Gleis.ROLE_CACHE ? y : z;
		Gleis c = x.getRole() == Gleis.ROLE_END ? x : y.getRole() == Gleis.ROLE_END ? y : z;
		
		//input A
		//Kleinsten finden und alle auf B schieben
		//Iterieren und Kleinsten auf A, Rest auf C
		//Dann solange C nicht leer ist
		//	Den nächst kleineren in C finden und alles auf B schieben
		//	Iterieren und Kleinsten auf A, Rest auf C
		
		Wagon smallestFirst = moveAndFindSmallest(a, b);
		seperateSmallestFromOthers(b, c, a, smallestFirst);
		
		while(!c.isEmpty()) {
			Wagon smallestNext = moveAndFindSmallest(c, b);
			seperateSmallestFromOthers(b, c, a, smallestNext);
		}
	}
	
	private static Wagon moveAndFindSmallest(Gleis from, Gleis to) {
		Wagon smallest = from.pop();
		to.push(smallest);
		
		while(!from.isEmpty()) {
			Wagon current = from.pop();
			
			if(smallest.getId() >= current.getId()) {
				smallest = current;
			}
			
			to.push(current);
		}
		
		return smallest;
	}
	
	private static void seperateSmallestFromOthers(Gleis from, Gleis cache, Gleis to, Wagon smallest) {
		while(!from.isEmpty()) {
			Wagon current = from.pop();
			
			if(current.getId() == smallest.getId()) {
				to.push(current);
			}else {
				cache.push(current);
			}
		}
	}
	
	private static void execute(Gleis x, Gleis y, Gleis z) {
		Gleis a = x.getRole() == Gleis.ROLE_START ? x : y.getRole() == Gleis.ROLE_START ? y : z;
		Gleis b = x.getRole() == Gleis.ROLE_CACHE ? x : y.getRole() == Gleis.ROLE_CACHE ? y : z;
		Gleis c = x.getRole() == Gleis.ROLE_END ? x : y.getRole() == Gleis.ROLE_END ? y : z;
		
		while(!a.getContent().isEmpty() && !b.getContent().isEmpty()) {
			Wagon firstA = a.pop();
			
			//If first wagon
			if(b.isEmpty() && c.isEmpty()) {
				b.push(firstA);
			}else if(!b.isEmpty() && c.isEmpty()) {
				if(firstA.getId() > b.top().getId()) {
					c.push(b.pop()); //Move from b to c
					b.push(firstA);
				}else if(firstA.getId() < b.top().getId()) {
					c.push(firstA);
				}
			}else if(!b.isEmpty() && !c.isEmpty()) {
				if(firstA.getId() > b.top().getId()) {
					while(firstA.getId() > b.top().getId()) {
						c.push(b.pop()); //Move from b to c
					}
					b.push(firstA);
				}else if(firstA.getId() < b.top().getId()) {
					while(firstA.getId() < c.top().getId()) {
						b.push(c.pop());
					}
					c.push(firstA);
				}
			}
		}
		System.out.println("Output - 1");
		
		while(!a.isEmpty()) {
			System.out.println(a.pop().getId() + " ");
		}
		
		System.out.println("Output - 2");
		
		while(!b.isEmpty()) {
			System.out.println(b.pop().getId() + " ");
		}
		
		System.out.println("Output - 3");
		
		while(!c.isEmpty()) {
			System.out.println(c.pop().getId() + " ");
		}
	}
}
