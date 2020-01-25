#include<iostream>
using namespace std;
int main() {
    int fs,gs,f[10],g[10],temp[20],j,k,crc[20],rs;
    cout<<"\n Enter size of data=";
    cin>>fs;
    cout<<"\n Enter the data bits:";
    for(int i=0;i<fs;i++)
        cin>>f[i];
    cout<<"\n Enter size of key=";
    cin>>gs;
    cout<<"\n Enter key bits:";
    for(int i=0;i<gs;i++)
        cin>>g[i];
        rs=gs-1;
    for(int i=fs;i<rs+fs;i++)
            f[i]=0;
    for(int i=0;i<fs+rs;i++)
        temp[i]=f[i];
    for(int i=0;i<fs;i++) {
        j=0;k=i;
        if(temp[k]>=g[j]) {
            for(j=0,k=i;j<gs;j++,k++) {   
                    if((temp[k]==1 && g[j]==1)||(temp[k]==0 && g[j]==0))
                        temp[k]=0;
                    else
                         temp[k]=1;
         	}
         }
    }  
    for(int i=0,k=fs;i<rs;i++,k++) 
        crc[i]=temp[k];
       cout<<"\n crc code is";
       for(int i=0;i<rs;i++)
        cout<<crc[i]<<" ";
     for(int i=fs,j=0;j<rs;i++,j++)
        f[i]=crc[j];
    cout<<"Sender code is:\n    ";   
    for(int i=0;i<fs+rs;i++)
        cout<<f[i]<<" ";
    return 0;
}
