package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BabaLogic {

	private Set<String> player;//終わったプレイヤーの格納場所
	private int firstPlayer;
	public BabaLogic() {//コンストラクタ
		this.firstPlayer=0;
		player = new HashSet<>();
	}

	public int getFirstPlayer() {return firstPlayer;}
	public void setFirstPlayer(int firstPlayer) {this.firstPlayer = firstPlayer;}

	public void initGame(Information info) {//山札を作るメソッド

		List<Integer> list = new ArrayList<>();//番号の呼び出し

		List<Integer> initDust = info.getInitDust();

		List<List<Integer>> dustbox = info.getDustbox();
		List<Integer> dust1 = new ArrayList<>();//プレイヤー1の手札
		List<Integer> dust2 = new ArrayList<>();//プレイヤー2の手札
		List<Integer> dust3 = new ArrayList<>();//プレイヤー3の手札
		List<Integer> dust4 = new ArrayList<>();//プレイヤー4の手札
		dustbox.add(dust1);
		dustbox.add(dust2);
		dustbox.add(dust3);
		dustbox.add(dust4);

		List<List<Integer>> init = info.getInit();//プレイヤーの呼び出し
		List<Integer> init1 = new ArrayList<>();//プレイヤー1の手札
		List<Integer> init2 = new ArrayList<>();//プレイヤー2の手札
		List<Integer> init3 = new ArrayList<>();//プレイヤー3の手札
		List<Integer> init4 = new ArrayList<>();//プレイヤー4の手札
		init.add(init1);
		init.add(init2);
		init.add(init3);
		init.add(init4);

		List<List<Integer>> initClear = info.getInitClear();//プレイヤーの呼び出し
		List<Integer> initClear1 = new ArrayList<>();//プレイヤー1の手札
		List<Integer> initClear2 = new ArrayList<>();//プレイヤー2の手札
		List<Integer> initClear3 = new ArrayList<>();//プレイヤー3の手札
		List<Integer> initClear4 = new ArrayList<>();//プレイヤー4の手札
		initClear.add(initClear1);
		initClear.add(initClear2);
		initClear.add(initClear3);
		initClear.add(initClear4);

		List<List<Integer>> player1 = new ArrayList<>();
		List<Integer> draw1 = new ArrayList<>();
		List<Integer> dump1 = new ArrayList<>();
		List<Integer> drawn1 = new ArrayList<>();
		player1.add(draw1);
		player1.add(dump1);
		player1.add(drawn1);

		List<List<Integer>> player2 = new ArrayList<>();
		List<Integer> draw2 = new ArrayList<>();
		List<Integer> dump2 = new ArrayList<>();
		List<Integer> drawn2 = new ArrayList<>();
		player2.add(draw2);
		player2.add(dump2);
		player2.add(drawn2);

		List<List<Integer>> player3 = new ArrayList<>();
		List<Integer> draw3 = new ArrayList<>();
		List<Integer> dump3 = new ArrayList<>();
		List<Integer> drawn3 = new ArrayList<>();
		player3.add(draw3);
		player3.add(dump3);
		player3.add(drawn3);

		List<List<Integer>> player4 =new ArrayList<>();
		List<Integer> draw4 = new ArrayList<>();
		List<Integer> dump4 = new ArrayList<>();
		List<Integer> drawn4 = new ArrayList<>();
		player4.add(draw4);
		player4.add(dump4);
		player4.add(drawn4);

		List<List<List<Integer>>> playerList = info.getPlayerList();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);

		List<List<Integer>> now = info.getNow();
		List<Integer> now1 = new ArrayList<>();
		List<Integer> now2 = new ArrayList<>();
		List<Integer> now3 = new ArrayList<>();
		List<Integer> now4 = new ArrayList<>();
		now.add(now1);
		now.add(now2);
		now.add(now3);
		now.add(now4);

		List<Integer> dust = info.getDust();


		for(int i=0;i<53;i++) {list.add(i);}
		while (list.size() > 1) {//playerにランダムにカードを配る
			for(int i=0;i<init.size();i++) {
				int x = (int) (Math.random() * list.size());//ランダムに配る
				now.get(i).add(list.get(x));//プレイヤーリストの0番目の手札に配る処理
				list.remove(x);
				if(list.size() == 1) {break;}
			}
		}
		int x = (int) (Math.random() * init.size());//ラスト1枚、プレイヤーリストの中からランダムに配る
		now.get(x).add(list.get(0));

		for(int i=0;i<now.size();i++) {
			copy(now.get(i),init.get(i));
			clearCards(now.get(i),dust);
			copy(now.get(i),initClear.get(i));
		}
		copy(dust , initDust);
	}

	public List<Integer> copy(List<Integer> origin , List<Integer> copy) {
		copy.clear();
		for (int o : origin){
			copy.add(o);
        }
		return copy;
	}

	public void start(Information info) throws Exception {
		int index = info.getIndex();//infoからコピー
		List<List<Integer>> dustbox = info.getDustbox();
		List<List<List<Integer>>> playerList = info.getPlayerList();//infoからコピー
		List<List<Integer>> now = info.getNow();
		List<Integer> dust = info.getDust();

		for(int i=0;i<now.size();i++) {
			for(int j=0;j<3;j++) {
				copy(now.get(i) , playerList.get(i).get(j));
			}
		}

		for (int i = 0; i < playerList.size(); i++) {//プレイヤーのリストに格納されている数分回す

			if (now.get(i).size() != 0) {//プレーヤーiの処理//プレイヤーの順番を回す
				rule(i, 1, playerList, index, now);
				clearCards(now.get(i) , dust);
				copy(now.get(i) , playerList.get(i).get(1));
			}
			copy(dust , dustbox.get(i));

			if (now.get(0).size()==0) {
				if(i==0) {copy(now.get(0) , playerList.get(0).get(2));}
				info.setFinish(true);
				info.setResult(player.size()+1);
				player.add("player1");
				break;
			}
			if (now.get(1).size()==0) {
				player.add("player2");
			}
			if (now.get(2).size()==0) {
				player.add("player3");
				}
			if (now.get(3).size()==0) {
				player.add("player4");
				}
			if (player.size()==3) {
				info.setFinish(true);
				info.setResult(player.size()+1);
				break;
			}
		}
	}

	public void rule(int i, int k, List<List<List<Integer>>> playerList, int index, List<List<Integer>> now) {//カードを引くメソッドindexとplayerlistはinfoからのコピー

		int x;
		if (i + k >= now.size()) {k = k - now.size();}//プレイヤーリストの人数をi+kが越えなければ

		if (now.get(i + k).size() != 0) {//i+k番目の手札があるならば

			System.out.println(i+"人目,惹かれる穂と："+(i+k)+"枚数："+now.get(i + k).size());

			if (i == 0) {x = index;}//プレイヤー１番目の人であればプレイヤーはindex番目の手札を加える処理
			else {x = (int) (Math.random() * now.get(i + k).size());}//それ以外であればランダムにx番目のカードを引く
			now.get(i).add(now.get(i+k).get(x));
			copy(now.get(i) , playerList.get(i).get(0));
			now.get(i + k).remove(x);//i+k番目から選んだカードを消す
			copy(now.get(i+k) , playerList.get(i+k).get(2));
			if(now.get(i + k).size()==0 && (i+k)!=0) {
				copy(now.get(i+k) , playerList.get(i+k).get(0));
				copy(now.get(i+k) , playerList.get(i+k).get(1));
				if ((i+k)==(now.size()+1) || ((i+k)==now.size() && now.get(now.size()-1).size()==0)) {copy(playerList.get(0).get(1) , playerList.get(0).get(2));}
			}
		} else {//ループ処理
			if(k==3){System.exit(0);}
			else{rule(i, k+1, playerList, index, now);}
		}
	}

	private void clearCards(List<Integer> list , List<Integer> dust) {//そろったカードを消すメソッド

		int i = 0;
		out: while (true) {
			//リストの要素数が０、または最後の値まで検証し終わったらループを抜ける
			if (list.size() == 0 || i == list.size() - 1) {
				break;
			}
			if(list.get(i)==52) {
				i++;
				continue;
			}
			Integer card1 = list.get(i);
			int j = i + 1;
			while (true) {
				//最後の値まで検証し終わったらループを抜ける
				if (j == list.size()) {
					break;
				}
				Integer card2 = list.get(j);
				if(list.get(j)==52) {
					j++;
					continue;
				}
				// 同一数値の要素を削除
				if (card1%13==card2%13) {
					dust.add(list.get(j));
					dust.add(list.get(i));
					list.remove(j);
					list.remove(i);
					i = 0;
					continue out;
				} else {
					j++;
				}
			}
			i++;
		}

		Collections.sort(dust);
	}

	private void displayCards(List<Integer> list) {//表の勝敗判定

		//プレイヤーのカードを出力する
		if (list.size() == 0) {
			//プレイヤーのカードが０枚の場合はプレイヤーの勝ち
			System.out.println("　　　　　　　　　　YOU WIN!!");
		} else {
			System.out.print("あなたのカード　　　：");
			for (Integer l : list) {
				//リストに保持している値を出力
				System.out.print("[");
				System.out.print(l);
				System.out.print("]");
			}
			System.out.println();
		}
	}

	private void displayCardsReverse(List<Integer> list) {//裏の勝敗判定
		//相手のカードを出力する
		if (list.size() == 0) {
			//相手のカードが０枚の場合は、プレイヤーの負け
			System.out.println("　　　　　　　　　　YOU LOSE!!");
		} else {
			System.out.print("相手のカード　　　　：");
			for (Integer l : list) {
				//数値を見せずに出力する
				System.out.print("[X]");
			}
			System.out.println();
		}
	}

	public void show(List<List<Integer>> playerlist) {//そろったカードを消すのと表示するメソッド
		for (int i = 0; i < 4; i++) {//4回回してi番目の手札を表示をする
			displayCards(playerlist.get(i));
		}
	}
}
