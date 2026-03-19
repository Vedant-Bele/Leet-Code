from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs):
        ans = defaultdict(list)
        for s in strs:
            key = tuple(sorted(s))
            ans[key].append(s)
        return list(ans.values())