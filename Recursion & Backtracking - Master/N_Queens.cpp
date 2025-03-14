/*
    *Author  : Aritra Dutta
    *Creater :  14.03.2025 23:23:13 (GMT+5:30)
*/

#include <bits/stdc++.h>
using namespace std;

#ifdef LOCAL
#define DEBUG(x) cerr << #x << " = " << x << '\n'
#else
#define DEBUG(x)
#endif

typedef long long ll;
typedef unsigned long long ull;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<pii> vpii;
typedef vector<pll> vpll;

const int INF = 1e9 + 5;
const ll LINF = 1e18 + 5;
const double EPS = 1e-9;
const ll MOD = 1e9 + 7;

#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define rep(i, a, b) for (int i = (a); i < (b); ++i)
#define per(i, a, b) for (int i = (a); i > (b); --i)
#define trav(a, x) for (auto& a : x)
#define pb push_back
#define mp make_pair
#define fi first
#define se second
#define sz(x) (int)((x).size())

inline ll gcd(ll a, ll b) { while (b) { a %= b; swap(a, b); } return a; }
inline ll lcm(ll a, ll b) { return a / gcd(a, b) * b; }
inline ll mod_exp(ll x, ll y, ll m) { ll res = 1; x %= m; while (y > 0) { if (y & 1) res = res * x % m; x = x * x % m; y >>= 1; } return res; }
inline ll mod_inv(ll x, ll m) { return mod_exp(x, m - 2, m); } // Only for prime m
inline ll mod_add(ll a, ll b, ll m = MOD) { return (a + b) % m; }
inline ll mod_sub(ll a, ll b, ll m = MOD) { return (a - b + m) % m; }
inline ll mod_mul(ll a, ll b, ll m = MOD) { return (a * b) % m; }

void fast_io() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

bool IsValid(const vector<int> &col_placement) {
    int row_id = col_placement.size() - 1;
    for (int i = 0; i < row_id; ++i) {
        int diff = abs(col_placement[i] - col_placement[row_id]);
        if (diff == 0 || diff == row_id - i) {
            return false;
        }
    }
    return true;
}

void solveNQueens(int n, int row, vector<int> &col_placement, vector<vector<int>> &result) {
    if (row == n) {
        result.push_back(col_placement);
    } else {
        for (int col = 0; col < n; ++col) {
            col_placement.push_back(col);
            if (IsValid(col_placement)) {
                solveNQueens(n, row + 1, col_placement, result);
            }
            col_placement.pop_back();
        }
    }
}

vector<vector<int>> NQueens(int n) {
    vector<vector<int>> result;
    vector<int> col_placement;
    solveNQueens(n, 0, col_placement, result);
    return result;
}

void solve() {
    int n;
    cin >> n;
    vector<vector<int>> solutions = NQueens(n);
    for (auto& solution : solutions) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solution[i] == j)
                    cout << "Q ";
                else
                    cout << ". ";
            }
            cout << "\n";
        }
        cout << "\n";
    }
}

int main() {
    fast_io();
    solve();
}
