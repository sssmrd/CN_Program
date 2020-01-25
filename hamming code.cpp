#include<stdio.h>
int main() {
    int data[7],i,c1,c2,c4,datar[7],c=0;
    printf("\n Enter 4 data bits=");
    scanf("%d",&data[0]);
    scanf("%d",&data[1]);
    scanf("%d",&data[2]);
    scanf("%d",&data[4]);
    data[6]=data[4]^data[2]^data[0];
    data[5]=data[4]^data[1]^data[0];
    data[3]=data[2]^data[1]^data[0];    
    printf("\n Data @sender is \n");
    for(i=0;i<7;i++)
        printf("%d",data[i]);
    printf("\n Enter data at receiver side=");
    for(i=0;i<7;i++)
        scanf("%d",&datar[i]);
    c1=datar[6]^datar[4]^datar[2]^datar[0];
    c2=datar[5]^datar[4]^datar[1]^datar[0];
    c4=datar[3]^datar[2]^datar[1]^datar[0];
    c=c4*4+c2*2+c1;
    if(c==0)
        printf("\n No error");  
     else
        printf("\n Error at %d bit",c);
     if(datar[7-c]==0)
        datar[7-c]=1;
     else
        datar[7-c]=0;   
     printf("\n Corrected data is \n");
     for(i=0;i<7;i++)
        printf("%d",datar[i]);
        
    return 0;
}