class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        dp = {} # key: index, value:[lengthLIS, count]
        lengthLIS, res = 0, 0
        for i in range(len(nums)-1, -1 ,-1): # start from the end
            maxLength, maxCount = 1,1 # for nums[i] length and count will be 1
            for j in range(i+1, len(nums)):
                if nums[j] > nums[i]: #increasing 
                    length,count = dp[j] # get the length and count of nums[j]
                    if length + 1 > maxLength:
                        maxLength,maxCount = length+1, count
                    elif length + 1 == maxLength: # we got another path for same LIS length, count it (all its subpath)
                         maxCount += count
            # update our final result
            if maxLength > lengthLIS:
                lengthLIS, res = maxLength,maxCount
            elif maxLength == lengthLIS:
                res += maxCount
            # update dp
            dp[i] = [maxLength,maxCount]
        return res
        