class Solution {
    int k, n;
    int[] prodArr;
    int[] cnt; // node*25 + r*5 + s

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        int sz = 4 * n + 4;
        prodArr = new int[sz];
        cnt = new int[sz * 25];
        build(1, 0, n - 1, nums);

        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, idx, val);
            long r = query(1, 0, n - 1, start, n - 1, 1 % k, x);
            res[i] = (int) (r / 5);
        }
        return res;
    }

    void setLeaf(int node, int value) {
        int v = value % k;
        prodArr[node] = v;
        int base = node * 25;
        for (int r = 0; r < k; r++) {
            int s = (r * v) % k;
            for (int ss = 0; ss < k; ss++) {
                cnt[base + r * 5 + ss] = (ss == s) ? 1 : 0;
            }
        }
    }

    void pullUp(int node) {
        int left = node * 2, right = node * 2 + 1;
        int lp = prodArr[left];
        prodArr[node] = (lp * prodArr[right]) % k;
        int base = node * 25, lb = left * 25, rb = right * 25;
        for (int r = 0; r < k; r++) {
            int rr = (r * lp) % k;
            int lbase = lb + r * 5;
            int rbase = rb + rr * 5;
            int obase = base + r * 5;
            for (int s = 0; s < k; s++) {
                cnt[obase + s] = cnt[lbase + s] + cnt[rbase + s];
            }
        }
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) { setLeaf(node, nums[l]); return; }
        int mid = (l + r) >>> 1;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        pullUp(node);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) { setLeaf(node, val); return; }
        int mid = (l + r) >>> 1;
        if (idx <= mid) update(node * 2, l, mid, idx, val);
        else update(node * 2 + 1, mid + 1, r, idx, val);
        pullUp(node);
    }

    long query(int node, int l, int r, int ql, int qr, int cur, int x) {
        if (r < ql || l > qr) return cur;
        if (ql <= l && r <= qr) {
            int p = prodArr[node];
            int ans = cnt[node * 25 + cur * 5 + x];
            int newCur = (cur * p) % k;
            return (long) ans * 5 + newCur;
        }
        int mid = (l + r) >>> 1;
        long leftRes = query(node * 2, l, mid, ql, qr, cur, x);
        int ansL = (int) (leftRes / 5);
        int curAfterL = (int) (leftRes % 5);
        long rightRes = query(node * 2 + 1, mid + 1, r, ql, qr, curAfterL, x);
        int ansR = (int) (rightRes / 5);
        int curAfterR = (int) (rightRes % 5);
        return (long) (ansL + ansR) * 5 + curAfterR;
    }
}