#include<algorithm>
#include<iostream>
#include<string.h>
#include<stdlib.h>
#include<stdio.h>

using namespace std; 
int main(int argc, char** argv) 
{   
    //reverse the comand line arguments after a/out and spepartes in endl :)
    string str;
    for(int run =2; run<argc;run++){ 
        for(int i=0;i<strlen(argv[run]);i++){
            str=argv[run];
        }
        reverse(str.begin(),str.end());
        cout<<"\n"<<str;
    }
    return 0;
}