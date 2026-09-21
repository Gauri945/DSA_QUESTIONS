class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int index, int parts,
                            List<String> current, List<String> ans) {

        // If 4 parts are created
        if (parts == 4) {
            if (index == s.length()) {
                ans.add(String.join(".", current));
            }
            return;
        }

        // Try length 1 to 3 for each part
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length())
                break;

            String part = s.substring(index, index + len);

            if (isValid(part)) {
                current.add(part);

                backtrack(s, index + len, parts + 1, current, ans);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String part) {

        // Leading zero check
        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(part);

        return num >= 0 && num <= 255;
    }
}