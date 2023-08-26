class Solution:
    def hIndex(self, citations: List[int]) -> int:
        length = len(citations)
        count = [0] * (length+1)
        for c in citations:
            if c > length:
                count[length] += 1
            else:
                count[c] +=1

        result = 0
        for i in range(length, 0,-1):
            result += count[i]
            if result >= i:
                return i
        return 0
    

            