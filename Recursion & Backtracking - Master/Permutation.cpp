/*
 *Author  : Aritra Dutta
 *Creater :  18.03.2025 01:56:02 (GMT+5:30)
 */

#include <bits/stdc++.h>
using namespace std;
#include <iostream>
#include <vector>

using namespace std;

void DirectedPermutations(int i, vector<int> *A_ptr, vector<vector<int>> *result)
{
    vector<int> &A = *A_ptr;

    if (i == A.size() - 1)
    {
        result->emplace_back(A);
        return;
    }

    for (int j = i; j < A.size(); ++j)
    {
        swap(A[i], A[j]);
        DirectedPermutations(i + 1, A_ptr, result);
        swap(A[i], A[j]);
    }
}

vector<vector<int>> permute(vector<int> nums)
{
    vector<vector<int>> result;
    DirectedPermutations(0, &nums, &result);
    return result;
}

int main()
{
    vector<int> A = {1, 2, 3};
    vector<vector<int>> result = permute(A);

    cout << "Permutations:\n";
    for (const auto &perm : result)
    {
        for (int num : perm)
        {
            cout << num << " ";
        }
        cout << endl;
    }

    return 0;
}
