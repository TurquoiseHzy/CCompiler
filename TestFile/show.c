struct mystruct{
    int attr1;
    char attr2;
    int* pointer;
};
typedef int int2;
int main(){
    mystruct x;
    mystruct *y;
    int2 z;
    x.attr1 = 10;
    y->attr2 = 100;
    z = 10;
    return 0;
}

