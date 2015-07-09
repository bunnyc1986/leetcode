/**
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] verSeg1 = version1.split("\\.");
        String[] verSeg2 = version2.split("\\.");
        int maxLength = verSeg1.length > verSeg2.length ? verSeg1.length : verSeg2.length;
        for (int i = 0; i < maxLength; i++) {
            int seg1 = i >= verSeg1.length ? 0 : Integer.parseInt(verSeg1[i]);
            int seg2 = i >= verSeg2.length ? 0 : Integer.parseInt(verSeg2[i]);
            if (seg1 != seg2) {
                return Integer.compare(seg1, seg2);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("0.1", "1.1"));
        System.out.println(compareVersionNumbers.compareVersion("2.1", "1.2"));
        System.out.println(compareVersionNumbers.compareVersion("1.2", "1.2.1"));
        System.out.println(compareVersionNumbers.compareVersion("1.0", "1"));
    }
}
