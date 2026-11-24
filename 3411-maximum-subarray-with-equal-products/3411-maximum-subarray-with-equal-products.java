import java.math.BigInteger;

class Solution {

    public int maxLength(int[] nums) {

        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            BigInteger product = BigInteger.ONE;

            int gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {

                
                product = product.multiply(
                    BigInteger.valueOf(nums[j])
                );

               
                gcd = gcd(gcd, nums[j]);

                
                lcm = lcm(lcm, nums[j]);

                BigInteger rightSide =
                    BigInteger.valueOf(lcm)
                              .multiply(BigInteger.valueOf(gcd));

                if (product.equals(rightSide)) {

                    int length = j - i + 1;

                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {

        return (a / gcdLong(a, b)) * b;
    }

    private long gcdLong(long a, long b) {

        while (b != 0) {

            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}