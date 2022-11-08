#include"Matrix3.h"
#include <iostream>
#include <fstream>
using namespace std;

using std::cout; using std::cerr;
using std::endl; using std::string;
using std::ifstream;

int readfile(string filename,int *val,size_t length){
    int number[9];

    ifstream input_file(filename);
    if (!input_file.is_open()) {
        cerr << "Could not open the file - '"
             << filename << "'" << endl;
        return EXIT_FAILURE;
    }
    int run=0;
    while (input_file >> number[run]) {
        val[run]=number[run];
        run++;
    }
    cout << endl;
    input_file.close();

}

int main(int argc,char* argv[])
{
    int val[9];

    readfile(argv[argc-1],val,sizeof(val)/sizeof(val[0]));

    Matrix3 M1(val[0],val[1],val[2],val[3],val[4],val[5],val[6],val[7],val[8]);

    readfile(argv[argc-2],val,sizeof(val)/sizeof(val[0]));
    
    Matrix3 M2(val[0],val[1],val[2],val[3],val[4],val[5],val[6],val[7],val[8]);
    Matrix3 M3=M1 + M2;
    std::cout << M1 << "     +" << M2 << "      =" << M3 << std::endl;

// writeing file
    fstream my_file;
	my_file.open(argv[argc-3], ios::out);
	if (!my_file) {
		cout << "File not created!";
	}
	else {
		cout << "File created successfully!";

		for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            my_file << M3.get(i,j)<<" ";
        }
         my_file <<"\n";
    }
    my_file.close();
  }
	

    return 0;
}