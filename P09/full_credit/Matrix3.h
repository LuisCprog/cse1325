#ifndef MATRIX3_H
#define MATRIX3_H

#include<istream>
#include<ostream>

class Matrix3{
private:
    /* data */
    int data[3][3];
public:
    Matrix3();
    Matrix3(int M00,int M01,int M02,int M10,int M11,int M12,int M20,int M21,int M22);
    int get(int x,int y);
    
    Matrix3 operator+(Matrix3);
    friend std::ostream& operator<<(std::ostream& output, Matrix3 m);
    friend std::istream& operator>>(std::istream& input, Matrix3 &m);
    
};
#endif