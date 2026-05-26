package Univ.Chaper_7;
import java.util.*;

public class exam_12 {
    private HashMap<String, Integer> vars = new HashMap<>(); // 변수 및 값을 받는 해쉬맵
    private Vector<String> instruction = new Vector<>(); // 명령어 라인 자체를 받는 벡터
    private Scanner sc = new Scanner(System.in);

    public int getValue(String opr){
        try {
            return Integer.parseInt(opr);
        } catch (NumberFormatException e) {
            return vars.getOrDefault(opr, 0);
        }
    }
    public void execute(){
        int pc = 0; // program counter 현재 실행중인 명령어 인덱스

        while(pc < instruction.size()){
            String [] tokens = instruction.get(pc).split(" ");
            String cmd = tokens[0];

            if(cmd.equals("mov")){
                vars.put(tokens[1],getValue(tokens[2]));
            }
            else if(cmd.equals("add")){
                vars.put(tokens[1], vars.get(tokens[1]) + getValue(tokens[2]));
            }
            else if(cmd.equals("sub")){
                vars.put(tokens[1], vars.get(tokens[1]) - getValue(tokens[2]));
            }
            else if(cmd.equals("jn0")){
                if(vars.get(tokens[1]) != 0){
                    pc = Integer.parseInt(tokens[2]);
                    continue;
                }
            }
            else if(cmd.equals("prt")){
                System.out.println("[prt " + tokens[1] + "]에 의해 출력된 " + tokens[1] + "변수 값 : " + vars.get(tokens[1]));
            }
            else if(cmd.equals("exi")){
                break;
            }
            pc++;
        }
        System.out.println("프로그램 실행 종료. 변수들의 최종 값을 출력합니다.");
        for(String key : vars.keySet()){
            System.out.print(key + ":" + vars.get(key) + " ");
        }
        System.out.println();
        vars.clear();
    }
    public void run(){
        System.out.println("나의 가상 컴퓨터가 작동합니다. 프로그램을 입력해주세요. go를 입력하면 작동합니다.");
        while(true){
            System.out.print(instruction.size() + ">> ");
            String line = sc.nextLine();
            if(line.equals("go")){
                execute();
                instruction.clear();
                continue;
            }
            instruction.add(line);
            if(line.equals("exi")){
                // 프로그램 종료 지시어지만, 입력은 받을 수 있도록 비워둠.
            }
        }
    }
    public static void main(String [] args){
        new exam_12().run();
    }
}