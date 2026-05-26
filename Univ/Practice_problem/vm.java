package Univ.Practice_problem;
import java.util.*;

public class vm {
    Vector<String> var_name = new Vector<>();
    Vector<Integer> var_data = new Vector<>();
    String lines[];

    public vm(String _in) {
        StringTokenizer st1 = new StringTokenizer(_in, "\n");
        int n = st1.countTokens();
        lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = st1.nextToken();
        }
    }

    void run() {
        for (int i = 0; i < lines.length; i++) {
            StringTokenizer st = new StringTokenizer(lines[i], " ");
            if (!st.hasMoreTokens()) continue;
            
            String instruction = st.nextToken();

            // prt 명령어: 특정 변수 하나만 출력
            if (instruction.equals("prt")) {
                String var = st.nextToken();
                int idx = var_name.indexOf(var);
                if (idx != -1) System.out.println("[출력] " + var + " : " + var_data.get(idx));
                continue;
            }

            String arg1 = st.nextToken(); 
            String arg2 = st.nextToken(); 

            int val2;
            int idx2 = var_name.indexOf(arg2);
            if (idx2 != -1) val2 = var_data.get(idx2);
            else val2 = Integer.parseInt(arg2);

            int idx1 = var_name.indexOf(arg1);
            if (idx1 == -1) {
                var_name.add(arg1);
                var_data.add(0);
                idx1 = var_name.size() - 1;
            }

            switch (instruction) {
                case "mov": var_data.set(idx1, val2); break;
                case "add": var_data.set(idx1, var_data.get(idx1) + val2); break;
                case "sub": var_data.set(idx1, var_data.get(idx1) - val2); break;
                case "jn0":
                    if (var_data.get(idx1) != 0) i = val2 - 1;
                    break;
            }
        }

        // 프로그램 종료 후 모든 변수 값 출력 로직 추가
        System.out.println("\n--- 모든 변수의 최종 상태 ---");
        for (int k = 0; k < var_name.size(); k++) {
            System.out.println(var_name.get(k) + " : " + var_data.get(k));
        }
    }

    public static void main(String[] args) {
        String _in = "mov sum 0\n" + 
                     "mov i 5\n" + 
                     "mov n 10\n" + 
                     "add sum i\n" + 
                     "add i 1\n" +   
                     "sub n 1\n" +   
                     "jn0 n 3\n" +   
                     "prt sum\n";

        vm i1 = new vm(_in);
        i1.run();
    }
}