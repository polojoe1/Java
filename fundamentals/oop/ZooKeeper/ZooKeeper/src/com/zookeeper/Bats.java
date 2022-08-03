package com.zookeeper;

public class Bats extends Mammals {
	private int energyLevel = this.getEnergyLevel() + 200;

	public int getEnergyLevelBat() {
		return energyLevel;
	}

	public void setEnergyLevelBat(int energyLevel) {
		this.energyLevel = energyLevel;
	} 
	
	public Bats fly() {
		this.setEnergyLevelBat(this.getEnergyLevelBat()-50);
		System.out.println("Starting flying, energy is now: "+this.getEnergyLevelBat());
		return this;
	}
	public Bats eatHumans() {
		this.setEnergyLevelBat(this.getEnergyLevelBat()+25);
		System.out.println("Just ate a HUMAN! energy is now: "+ this.getEnergyLevelBat());
		return this;
	}
	
	public Bats attackTown() {
		this.setEnergyLevelBat(this.getEnergyLevelBat()-100);
		System.out.println("Another ATTACK! energy level is: "+ this.getEnergyLevelBat());
		return this;
	}
}
