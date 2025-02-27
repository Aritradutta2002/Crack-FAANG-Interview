import sys
from collections import deque
def input(): return sys.stdin.readline().strip()
def inputlist(): return list(map(int, input().split()))
def printlist(var) : sys.stdout.write(' '.join(map(str, var))+'\n')
def print(var) : sys.stdout.write(str(var)+'\n')

for _ in range(int(input())):
    k = [int(a) for a in input().split()]
    n=k[0]
    x=k[1]
    array = [int(a) for a in input().split()]
    ma = max(array)
    get_bin = lambda x: format(x, 'b')
    m = len(get_bin(ma))

    mem = []

    for i in array:
        arr = [False] * m;
        s = get_bin(i)
        # print(s)
        size = len(s) - 1
        ptr = m - 1
        while(size >= 0):
            arr[ptr] = s[size] == '1'
            ptr -=1
            size-=1
        mem.append(arr)

    list = []
    for i in range(m):
        list.append(deque())
    
    i = n - 1
    j = 0
    # print(mem)
    while(i >=0):
        j = 0
        while(j < m):
            if(mem[i][j]):
                list[j].append(i)
            j+=1
        i-=1

    i = 0
    j = 0
    # print(list)
    while( i < n - 1 and x > 0):
        j = 0
        while(j < m and x > 0):
            if(mem[i][j] and x > 0):
                if(len(list[j]) != 0):
                    poped = list[j].pop()
                else:
                    poped = 0

                if(poped == i):
                    if(len(list[j]) != 0):
                        poped = list[j].pop()
                    else:
                        poped = 0
                mem[poped][j] = not mem[poped][j]
                mem[i][j] = False
                x-=1
            j+=1
        i+=1
    if(x % 2 == 1 and n <= 2):
        mem[n - 1][m - 1] = not mem[n - 1][m - 1];
        mem[n - 2][m - 1] = not mem[n - 2][m - 1];

    for i in range(0, n):
        s =""
        for b in mem[i]:
            if(b):
                s+="1"
            else:
                s+="0"
        # print(s)
        array[i] = int(s, 2)
    s=""
    for i in array:
        s+=str(i)
        s+=" "
    print(s)