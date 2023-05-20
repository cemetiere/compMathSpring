#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n, k;
    cin >> n >> k;
    vector<int> purchs;
    int c;
    for(int i = 0; i<n; i++){
        cin >> c;
        purchs.push_back(c);
    }
    sort(purchs.begin(), purchs.end());
    int sum = 0;
    int count = 1;
    for(int i = purchs.size() -1; i>=0; i--){
        if(count!=k){
            sum+=purchs[i];
            count++;
        } else {
            count =1;
        }
    }
    cout << sum;
}