#! /usr/bin/env python
# *-* coding:utf-8 *-*


class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 1

        MIN = 0
        MAX = 0
        for num in nums:
            if num <= 0:
                pass
            else:
                MIN = num
                MAX = num
        total = 0
        for num in nums:
            if num <= 0:
                pass
            else:
                total += num
                MIN = min(MIN, num)
                MAX = max(MAX, num)
        origin_total = 0
        for i in range(MIN, MAX + 1):
            origin_total += i
        if origin_total == total:
            if MIN != 1:
                return MIN - 1 <= 0 and 1 or MIN - 1
            else:
                return MAX + 1
        return origin_total - total


if __name__ == '__main__':
    s = Solution()
    # print s.firstMissingPositive([1, 2, 4])
    print s.firstMissingPositive([0,1])
