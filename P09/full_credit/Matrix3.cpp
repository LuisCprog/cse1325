#include"Matrix3.h"
#include<iostream>
# include<istream>
#include<ostream>
#include <exception>
using namespace std;

Matrix3::Matrix3(){
            data[0][0]=0;
            data[0][1]=0;
            data[0][2]=0;
            data[1][0]=0;
            data[1][1]=0;
            data[1][2]=0;
            data[2][0]=0;
            data[2][1]=0;
            data[2][2]=0;
        }

Matrix3::Matrix3(int M00,int M01,int M02,int M10,int M11,int M12,int M20,int M21,int M22){
        data[0][0]=M00;
        data[0][1]=M01;
        data[0][2]=M02;
        data[1][0]=M10;
        data[1][1]=M11;
        data[1][2]=M12;
        data[2][0]=M20;
        data[2][1]=M21;
        data[2][2]=M22;
    }

int Matrix3::get(int x,int y){
    if(  (x>2 || x<0) ||(y>2||y<0) ){
        throw runtime_error("Something Bad happened here");
        }
    data[x][y];
    return data[x][y];
}

Matrix3 Matrix3::operator+(Matrix3 aso){
    int val[3][3];
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            val[i][j]=data[i][j]+aso.get(i,j);
        }
    }
    Matrix3 brandNew(val[0][0],val[0][1],val[0][2],val[1][0],val[1][1],val[1][2],val[2][0],val[2][1],val[2][2]);
    return brandNew;
}

ostream& operator <<(ostream& output,Matrix3 m){
    output<<endl<<m.get(0,0)<<" "<<m.get(0,1)<<" "<<m.get(0,2)<<endl
    <<m.get(1,0)<<" "<<m.get(1,1)<<" "<<m.get(1,2)<<endl
    <<m.get(2,0)<<" "<<m.get(2,1)<<" "<<m.get(2,2)<<endl;
    return output;
}

istream& operator>>(istream& input, Matrix3 &m){
    int i, j;
    cout<<"Enter a #X# matrix: "<<endl;
    for(i=0;i<3;i++){
        for(j=0;j<3;j++){
            input>>m.data[i][j];
        }
    }
    return input;
}
