package asteroidplugin3package;

import asteroidplugin2package.IClock;

public class Clock implements IClock {

	public float millisPerCycle;
	public int elapsedCycles;
	public float excessCycles;
	public boolean isPaused;
	public long lastUpdate;
	
	//public Clock(){
	
	//}
	//@Override
	public Clock() {
		// TODO Auto-generated constructor stub
		//setCyclesPerSecond(cyclesPerSecond);
		//reset();
		System.out.println("making a clock");
	}
	
	@Override
	public void setCyclesPerSecond(float cyclesPerSecond) {
		// TODO Auto-generated method stub
		this.millisPerCycle = (1.0f / cyclesPerSecond) * 1000;
	}
	
	@Override
	public void reset() {
		this.elapsedCycles = 0;
		this.excessCycles = 0.0f;
		this.lastUpdate = getCurrentTime();
		this.isPaused = false;
	}
	@Override
	public void setPaused(boolean paused) {
		// TODO Auto-generated method stub
		this.isPaused = paused;
	}

	@Override
	public boolean isPaused() {
		return isPaused;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasElapsedCycle() {
		// TODO Auto-generated method stub
		if(elapsedCycles > 0) {
			this.elapsedCycles--;
			return true;
		}
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//Get the current time and calculate the delta time.
		long currUpdate = getCurrentTime();
		float delta = (float)(currUpdate - lastUpdate) + excessCycles;
		
		//Update the number of elapsed and excess ticks if we're not paused.
		if(!isPaused) {
			this.elapsedCycles += (int)Math.floor(delta / millisPerCycle);
			this.excessCycles = delta % millisPerCycle;
		}
		
		//Set the last update time for the next update cycle.
		this.lastUpdate = currUpdate;
	}
	
	public long getCurrentTime() {
		return (System.nanoTime() / 1000000L);
	}
}
