package StructuralPattern.H_Facade;

class Amplifier {

	public void on() {
		// TODO Auto-generated method stub

	}

	public void setDvd(DvdPlayer dvd) {
		// TODO Auto-generated method stub

	}

	public void setSurroundSound() {
		// TODO Auto-generated method stub

	}

	public void setVolume(int i) {
		// TODO Auto-generated method stub

	}

	public void off() {
		// TODO Auto-generated method stub

	}

}

class Tuner {

}

class DvdPlayer {

	public void play(String movie) {
		// TODO Auto-generated method stub

	}

	public void on() {
		// TODO Auto-generated method stub

	}

	public void sto() {
		// TODO Auto-generated method stub

	}

	public void eject() {
		// TODO Auto-generated method stub

	}

	public void off() {
		// TODO Auto-generated method stub

	}

}

class CdPlayer {

}

class Projector {

	public void on() {
		// TODO Auto-generated method stub

	}

	public void wideScreenMode() {
		// TODO Auto-generated method stub

	}

	public void off() {
		// TODO Auto-generated method stub

	}

}

class TheaterLights {

	public void dim(int i) {
		// TODO Auto-generated method stub

	}

	public void on(int i) {
		// TODO Auto-generated method stub

	}

}

class Screen {

	public void down() {
		// TODO Auto-generated method stub

	}

	public void up() {
		// TODO Auto-generated method stub

	}

}

class PopcornPopper {

	public void on() {
		// TODO Auto-generated method stub

	}

	public void pop() {
		// TODO Auto-generated method stub

	}

	public void off() {
		// TODO Auto-generated method stub

	}

}

public class HomeTheaterFacade {
	// 组合
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;

	public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd,
			CdPlayer cd, Projector projector, TheaterLights lights,
			Screen screen, PopcornPopper popper) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.lights = lights;
		this.screen = screen;
		this.popper = popper;
	}

	public void watchMovie(String movie) {
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amp.on();
		amp.setDvd(dvd);
		amp.setSurroundSound();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}

	public void endMovie() {
		popper.off();
		lights.on(10);
		screen.up();
		projector.off();
		amp.off();
		dvd.sto();
		dvd.eject();
		dvd.off();
	}

}
