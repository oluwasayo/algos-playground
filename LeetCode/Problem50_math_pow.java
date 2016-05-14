public class Solution {
  public double myPow(double x, int n) {
    if (n == 0) return 1.0;
    if (n < 0) { x = 1 / x; n = 0 - n; }
    if (n == 1) return x;
    if (n == 2) return x * x;
    if ((n & 1) == 1) return x * myPow(myPow(x, 2), (n - 1) >> 1);
    return myPow(myPow(x, 2), n >> 1);
  }
}

// PYTHON
// def myPow(self, x, n):
//   if n == 0: return 1.0
//   if n < 0:
//       n = 0 - n
//       x = 1 / x
//   if n == 1: return x;
//   if n == 2: return x * x;
//   if n % 2 == 1: return x * self.myPow(x * x, n / 2)
//   return self.myPow(x * x, n / 2)