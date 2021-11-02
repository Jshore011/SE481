package asteroidplugin2package;

public interface IClock {
	//public Clock();
	void setCyclesPerSecond(float cyclesPerSecond);
	void setPaused(boolean paused);
	boolean isPaused();
	boolean hasElapsedCycle();
	void update();
	long getCurrentTime();
	void reset();
	
	
}
