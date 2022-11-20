class Solution { 
    public: 
bool isPalindrome(int x) {
	bool result = true;
	int a = x;
	int b = 0;
	int d = 0;
	if (x < 0)
		return false;
	if (x > 0) {
		while (x != 0) {
			b = x % 10;
			x /= 10;
			if (d > INT_MAX / 10 || (d == INT_MAX / 10 && b > 7)) return 0;
			if (d < INT_MIN / 10 || (d == INT_MIN / 10 && b < -8)) return 0;
			d = d * 10 + b;
		};
		if (d == a) {
			result = true;
		}
		else result = false;
	}
	return result;}};