package StructuralPattern.N_Composite.mvc;

/**
 * 节拍模型
 */
public interface BeatModelInterface {

	void initialize();

	void on();

	void off();

	void setBPM(int bpm);

	int getBPM();

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BPMObserver o);

	void removeObserver(BPMObserver o);
}
