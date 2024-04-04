public class LottoStatistic {

  public static void main(String[] args) {

    RandNum lottoNum = new RandNum();
    Match lotto = new Match();
    long buyNum = 0;

    while (true) {

      RandNum myNum = new RandNum();
      buyNum++;
      System.out.print(buyNum + "번째 구입 로또  : ");
      myNum.showNumber();

        if (lotto.matchNum(lottoNum, myNum) == 6) {
            break;
        }
        if (buyNum > 349999) {
            break;
        }
    }
    // while 문 종료지점--------------------------------------------------

    int[] prize = {1000000000, 60000000, 1000000, 50000, 5000};
    int totalPrize = 0;

    System.out.println("========= 결 산 ========");
    for (int i = 0; i < 5; i++) {
      System.out.print(i + 1 + "등 총 상금 : " + lotto.win[i] * prize[i] + " 원   ");
      System.out.print("당첨횟수 : " + lotto.win[i]);
      System.out.println("\t 당첨확률 : " + (double) lotto.win[i] / buyNum + "%");
      totalPrize += lotto.win[i] * prize[i];
    }
    System.out.println("총 로또 구매 금액 : " + buyNum * 1000);
    System.out.println("합산 : " + (totalPrize - buyNum * 1000));
  }
}

//해당클래스종료지점--------------------------------------------------------
//난수 발생 클래스
class RandNum {        //난수 발생 클래스

  int[] rNum = new int[7];

  public RandNum() {        //난수 발생 메소드

    for (int i = 0; i < 7; i++) {
      rNum[i] = (int) (Math.random() * 45) + 1;

      for (int j = 0; j < i; j++) {
        if (rNum[i] == rNum[j]) {
          i--;
          break;
        }
      }
    }
  }

  public void showNumber() {        //발생된 난수 보여주기
    for (int i = 0; i < 6; i++) {
      System.out.print("(" + rNum[i] + ") ");
    }
  }
}

// 번호 맞추는 클래스
class Match {        //내 번호와 로또 번호 비교

  int[] win = {0, 0, 0, 0, 0};

  int matchNum(RandNum lottoNum, RandNum myNum) {

    int cnt;
    cnt = 0;

      for (int i = 0; i < 6; i++) {
          for (int j = 0; j < 6; j++) {
              if (lottoNum.rNum[i] == myNum.rNum[j]) {
                  cnt++;
              }
          }
      }

    switch (cnt) {            // 당첨 순위

      case 3:
        win[4]++;
        System.out.println("\t\t5등 당첨");
        break;
      case 4:
        win[3]++;
        System.out.println("\t\t\t4등 당첨");
        break;
      case 5:
        for (int i = 0; i < 6; i++) {
          if (myNum.rNum[i] == lottoNum.rNum[6]) {
            win[1]++;
            System.out.println("\t\t\t\t\t2등 당첨");
          }
        }
        win[2]++;
        System.out.println("\t\t\t\t3등 당첨");
        break;
      case 6:
        if (cnt == 6) {
          win[0]++;
          System.out.println();
          System.out.println("<로또 번호 당첨 번호>");
          lottoNum.showNumber();
          System.out.println(" 보너스:" + lottoNum.rNum[6]);
        }
        break;
      default:
        System.out.println("  당첨 실패!!!");
        break;
    }

    return cnt;
  }
}