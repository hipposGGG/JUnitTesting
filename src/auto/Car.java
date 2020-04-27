package auto;

public class Car {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}
	//　車種名
	String carName;

	//　燃料
	int fuel;

	int highRoadFee;

	//　給油
	void oiling() {
		this.fuel = 80;
		System.out.println(this.carName + "は、ガソリンスタンドで給油した");
	}

	//　走行距離
	void distance(int km) {
		//　1kmで消費する燃料
		int num = km / 10;

		//　給油した燃料から消費した燃料を算出
		this.fuel -= num;

		System.out.println(km + "km走って"+ num +"Lのガソリンを消費した");
		System.out.println("残りの燃料は" + this.fuel + "Lです。");
	}

	public void distanceHigh(int km) {

		int result = calc(km);

		if(result == 3) {

			System.out.println("かなりの距離を走行してます");

		}else if(result == 2) {



		}else if(result == 1) {



		}else if(result == 0) {

		}

	}

	public int calc(int km) {

		int result = 0;

		if(0 != km && km > 0) {
			result = km / 5;
		}

		return result;
	}



}
