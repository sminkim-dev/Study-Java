package study_Java.chap_5;

abstract class PairMap {
    protected String keyArray []; // 키 문자열을 저장하는 배열
    protected String valueArray []; // 값 문자열을 저장하는 배열
    abstract public String get(String key); // 키 값으로 value 검색
    abstract public void put(String key, String value); // key와 value를 쌍으로 저장
    abstract public String delete(String key); // key 값을 가진 아이템 삭제. 삭제된 value 리턴
    abstract public int length(); // 현재 저장된 아이템 개수 리턴
}

class Dictionary extends PairMap {
    private int count; // 현재 저장된 아이템 개수

    public Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
        count = 0;
    }

    @Override
    public String get(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null; // 못 찾으면 null
    }

    @Override
    public void put(String key, String value) {
        // 1. 이미 있는 키인지 확인 (수정 로직)
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }

        // 2. 새로운 키 추가 (배열 범위 체크 생략 - 문제 조건에 맞춤)
        if (count < keyArray.length) {
            keyArray[count] = key;
            valueArray[count] = value;
            count++;
        }
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                String targetValue = valueArray[i];

                // 데이터를 앞으로 당기기 (삭제 로직)
                for (int j = i; j < count - 1; j++) {
                    keyArray[j] = keyArray[j + 1];
                    valueArray[j] = valueArray[j + 1];
                }
                count--;
                return targetValue;
            }
        }
        return null; // 삭제할 키가 없으면 null
    }

    @Override
    public int length() {
        return count;
    }
}

public class ex_5_12 {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정

        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));

        dic.delete("황기태"); // 황기태 아이템 삭제
        System.out.println("황기태의 값은 " + dic.get("황기태")); // 삭제되었으므로 null 출력
    }
}
