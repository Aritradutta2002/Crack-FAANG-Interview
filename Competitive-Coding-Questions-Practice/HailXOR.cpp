#include<bits/stdc++.h>
using namespace std;
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    long long int t,n,i,j,len,k,i1,i2,cnt,ans,o,c,flag,p,count;
    string s,a,b,aa;
    map<string,vector<long long int>> m;
    set<string> v;
    cin>>t;
    while(t--)
    {
        cin>>s;
        n=s.size();
        v.clear();
        string arr[n*(n+1)/2];
        a="";
        for(len=1;len<=n;len++) 
        {    
            for(i=0;i<=n-len;i++) 
            {
                j=i+len-1; 
                a="";
                flag=0;
                c=0;
                cnt=0;
                ans=0;
                o=0;
                p=i;
                i1=i;
                i2=j;
                for (k=j;k>=i;k--) 
                {
                    if(s[k]=='1' && flag==0)
                    {
                        flag=1;
                        i1=k-i;
                        o++;
                    }
                    else if(s[k]=='1')
                    {
                        i2=k-i;
                        cnt++;
                        if(cnt%2!=0)
                        {
                            ans+=abs(i1-i2);
                        }
                        i1=i2;
                        o++;
                    }
                    a=a+s[p++];
                }
                if(cnt%2==0)
                {
                    //cout<<i1<<" "<<i<<" ";
                    ans+=abs(i1);
                }
                m[a]={ans,o,(long long int)a.size()};
                v.insert(a);
                //cout<<a<<" "<<ans<<endl;
            }
        }
        
        set<string>::iterator itr;
        k=0;
        count=0;
        for(itr=v.begin();itr!=v.end();++itr)
        {
            if(*itr=="0" || *itr=="1" || *itr=="01" || *itr=="10" || *itr=="00" || *itr=="11")
            {
                count++;
            }
            else
            {
                arr[k++]=*itr;
                //cout<<arr[k-1]<<" ";
                count++;
            }
        }
        //cout<<count<<endl;
        for(i=0;i<k;i++)
        {
            a=arr[i];
            for(j=i+1;j<k;j++)
            {
                b=arr[j];
                if(a!="2" && b!="2")
                {
                    if(m[a][0]==m[b][0] && m[a][1]==m[b][1] && m[a][2]==m[b][2])
                    {
                        //cout<<a<<" "<<b<<endl;
                        arr[i]="2";
                        arr[j]="2";
                        count--;
                        //cout<<"hello world";
                    }
                }
            }
        }
        cout<<count<<endl;
        
    }
}