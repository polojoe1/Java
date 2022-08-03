package com.zookeeper;

public class Gorilla extends Mammals {
	public void throwPoop() {
		this.setEnergyLevel(this.getEnergyLevel()-5);
		System.out.println("EW! your enery is now: "+this.getEnergyLevel());
	}
	public Gorilla eatNanna() {
		this.setEnergyLevel(this.getEnergyLevel()+10);
		System.out.println("Yum! your enery is now: "+this.getEnergyLevel());
		return this;
	}
	public void climbUp() {
		this.setEnergyLevel(this.getEnergyLevel()-10);
		System.out.println("WHEW! your enery is now: "+this.getEnergyLevel());

	}
}
