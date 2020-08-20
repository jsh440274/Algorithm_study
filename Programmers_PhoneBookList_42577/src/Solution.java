class Solution {
    public boolean solution(String[] phone_book) {
//        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            String src = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                if (j == i) continue;
                String dst = phone_book[j];
                if (dst.contains(src)) {
                    if (dst.startsWith(src)) return false;
                }
            }
        }

        return true;
    }
}