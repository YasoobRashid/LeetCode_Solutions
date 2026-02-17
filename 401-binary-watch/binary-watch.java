class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hBits = 0; hBits <= Math.min(4, turnedOn); hBits++) {
            int mBits = turnedOn - hBits;

            if (mBits > 6) continue;

            for (int h = 0; h < 12; h++) {
                if (Integer.bitCount(h) != hBits) continue;

                for (int m = 0; m < 60; m++) {
                    if (Integer.bitCount(m) != mBits) continue;

                    result.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return result;
    }
}