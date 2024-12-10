class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int maxLength = -1;
        
        // Iterate over possible lengths of special substrings
        for (int len = 1; len <= n; len++) {
            int count = 0;
            for (int i = 0; i + len <= n; i++) {
                String substring = s.substring(i, i + len);
                if (isSpecial(substring)) {
                    count = countOccurrences(s, substring);
                    if (count >= 3) {
                        maxLength = Math.max(maxLength, len);
                    }
                }
            }
        }
        
        return maxLength;
    }
    
    // Function to check if a string is special
    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) return false;
        }
        return true;
    }
    
    // Function to count occurrences of a substring in a string
    private int countOccurrences(String s, String sub) {
        int count = 0;
        int index = 0;
        while ((index = s.indexOf(sub, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }
}

