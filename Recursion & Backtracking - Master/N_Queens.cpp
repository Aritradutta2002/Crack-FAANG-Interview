/*
    *Author  : Aritra Dutta
    *Creater :  14.03.2025 23:23:13 (GMT+5:30)
*/
#include <bits/stdc++.h>
using namespace std;

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