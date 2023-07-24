package decorator;

import w17d1esercizio.entities.Pizza;

public class CottoDecorator extends Pizza {
	public CottoDecorator(Pizza pizza) {
		super(pizza.getName() + " + prosciutto cotto", pizza.getPrice() + 1.5, pizza.getCalorie() + 30);
	}

//	public String getName() {
//		return super.getName() + " + prosciutto cotto";
//	}
//
//	public double getPrice() {
//		return super.getPrice() + 1.5;
//	}
//
//	public double getCalorie() {
//		return super.getCalorie() + 30;
//	}

}
