#include <bits/stdc++.h>

using namespace std;

int main() {
    
    vector<int> v1 {1, 2, 3, 4};

    vector<int> v2 = v1;

    v2[0] = 33;

    for (auto v : v1) printf("%d, ", v);
    cout << endl;
    for (auto v : v2) printf("%d, ", v);
    cout << endl;

    return 0;
}
