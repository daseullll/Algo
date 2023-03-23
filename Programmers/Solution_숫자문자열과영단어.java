
class Solution_숫자문자열과영단어 {
    static public int solution(String s) {
        char[] input = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (input[i] - '0' >= 0 && input[i] - '0' <= 9) {
                sb.append(input[i]);
                continue;
            }
            if (input[i] == 'z') {
                sb.append("0");
                i = i + 3;
                continue;
            }
            if (input[i] == 'o') {
                sb.append("1");
                i = i + 2;
                continue;
            }
            if (input[i] == 't' && input[i + 1] == 'w') {
                sb.append("2");
                i = i + 2;
                continue;
            }
            if (input[i] == 't' && input[i + 1] == 'h') {
                sb.append("3");
                i = i + 4;
                continue;
            }
            if (input[i] == 'f' && input[i + 1] == 'o') {
                sb.append("4");
                i = i + 3;
                continue;
            }
            if (input[i] == 'f' && input[i + 1] == 'i') {
                sb.append("5");
                i = i + 3;
                continue;
            }
            if (input[i] == 's' && input[i + 1] == 'i') {
                sb.append("6");
                i = i + 2;
                continue;
            }
            if (input[i] == 's' && input[i + 1] == 'e') {
                sb.append("7");
                i = i + 4;
                continue;
            }
            if (input[i] == 'e') {
                sb.append("8");
                i = i + 4;
                continue;
            }
            if (input[i] == 'n') {
                sb.append("9");
                i = i + 3;
                continue;
            }

        }

        System.out.println(Integer.parseInt(sb.toString()));
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        solution("one4seveneight");
    }
}