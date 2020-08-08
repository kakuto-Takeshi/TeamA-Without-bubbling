package model;

import java.util.ArrayList;
import java.util.List;

public class Information {
	private int index;
	private List<Integer> initDust;
	private List<List<Integer>> dustbox;
	private List<List<Integer>> init;
	private List<List<Integer>> initClear;
	private List<List<List<Integer>>> playerList;
	private List<List<Integer>> now;
	private List<Integer> dust;
	private boolean finish;
	private int result;

	public Information() {
		index = 0;//代入
		initDust = new ArrayList<>();
		dustbox = new ArrayList<>();
		init = new ArrayList<>();
		initClear = new ArrayList<>();
		playerList = new ArrayList<>();
		now = new ArrayList<>();
		dust = new ArrayList<>();
		finish = false;
		result = 0;
	}

	public int getIndex() {return index;}
	public List<Integer> getInitDust() {return initDust;}
	public List<List<Integer>> getDustbox() {return dustbox;}
	public List<List<Integer>> getInit() {return init;}
	public List<List<Integer>> getInitClear() {return initClear;}
	public List<List<List<Integer>>> getPlayerList() {return playerList;}
	public List<List<Integer>> getNow() {return now;}
	public List<Integer> getDust() {return dust;}
	public boolean isFinish() {return finish;}
	public int getResult() {return result;}

	public void setIndex(int index) {this.index = index;}
	public void setInitDust(List<Integer> initDust) {this.initDust = initDust;}
	public void setDustbox(List<List<Integer>> dustbox) {this.dustbox = dustbox;}
	public void setInit(List<List<Integer>> init) {this.init = init;}
	public void setInitClear(List<List<Integer>> initClear) {this.initClear = initClear;}
	public void setPlayerList(List<List<List<Integer>>> playerList) {this.playerList = playerList;}
	public void setNow(List<List<Integer>> now) {this.now = now;}
	public void setDust(List<Integer> dust) {this.dust = dust;}
	public void setResult(int result) {this.result = result;}
	public void setFinish(boolean finish) {this.finish = finish;}
}
