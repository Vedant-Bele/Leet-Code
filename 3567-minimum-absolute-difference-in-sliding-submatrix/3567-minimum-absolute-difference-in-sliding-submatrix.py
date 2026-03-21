class Solution:
    def minAbsDiff(self, grid, k):
        m, n = len(grid), len(grid[0])
        ans = [[0] * (n - k + 1) for _ in range(m - k + 1)]

        for i in range(m - k + 1):
            for j in range(n - k + 1):
                vals = set()
                for x in range(i, i + k):
                    for y in range(j, j + k):
                        vals.add(grid[x][y])
                vals = sorted(vals)
                md = float('inf')
                for t in range(1, len(vals)):
                    md = min(md, vals[t] - vals[t - 1])
                ans[i][j] = 0 if md == float('inf') else md

        return ans