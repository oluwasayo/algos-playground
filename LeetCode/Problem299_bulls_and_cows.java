public class Solution {
    public String getHint(String secret, String guess) {
        int[] secretArr = new int[10], guessArr = new int[10];
        int bull = 0, cow = 0;
        for (int a = 0; a < secret.length(); a++) {
            if (secret.charAt(a) == guess.charAt(a)) bull++;
            else {
                secretArr[secret.charAt(a) - '0']++;
                guessArr[guess.charAt(a) - '0']++;
            }
        }

        for (int a = 0; a < secretArr.length; a++) cow += Math.min(secretArr[a], guessArr[a]);
        return String.format("%dA%dB", bull, cow);
    }
}