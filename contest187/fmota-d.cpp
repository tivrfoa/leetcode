#include <bits/stdc++.h>

using namespace std;

class Solution {
    public:
        int kthSmallest(vector<vector<int>> &mat, int k) {
            int n = mat.size(), m = mat[0].size();
            set<pair<int, vector<int>>> mp;
            int sum = 0;
            for (int i = 0; i < n; i++) sum += mat[i][0];
            mp.insert(make_pair(sum, vector<int>(n, 0)));
            vector<int> all;
            while (all.size() < k) {
                auto [v, ind] = *mp.begin();
                mp.erase(mp.begin());
                all.push_back(v);
                for (int i = 0; i < n; i++) {
                    if (ind[i] + 1 < m) {
                        vector<int> cp = ind;
                        cp[i]++;
                        mp.insert(make_pair(v - mat[i][ind[i]] + mat[i][ind[i] + 1], cp));
                    }
                }
            }
            return all[k-1];
        }
};

int main() {
    
    Solution s;

    vector<vector<int>> mat {
        {1,10,10},
        {1,4,5},
        {2,3,6}
    };
    int k = 7;

    cout << s.kthSmallest(mat, k) << endl;

    return 0;
}
