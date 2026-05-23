package study_Java.chap_4;

class Account{
    int totalMoney;
    public Account(int num){
        this.totalMoney += num;
    }
    public void desposit(int... money){
        for(int i = 0; i < money.length; i++){
            this.totalMoney += money[i];
        }
    }
    public int getValence(){
        return totalMoney;
    }
    public int withDraw(int money){
        if(this.totalMoney > money){
            this.totalMoney -= money;
            return money;
        }
        else{
            int wMoney = totalMoney;
            totalMoney = 0;
            return wMoney;
        }
    }
}
public class ex_4_8 {
    public static void main(String[] args){
        Account a = new Account(100);
        a.desposit(5000);
        System.out.println("잔금은 " + a.getValence() + "원입니다.");

        int bulk [] = {100, 500, 200, 700};
        a.desposit(bulk);
        System.out.println("잔금은 " + a.getValence() + "원입니다.");

        int money = 1000; // 인출하고자 하는 돈
        int wMoney = a.withDraw(money);
        System.out.println((wMoney < money) ? (wMoney + "원만 인출") : (wMoney + "원 인출"));

        System.out.println("잔금은 " + a.getValence() + "원입니다.");
    }
}
