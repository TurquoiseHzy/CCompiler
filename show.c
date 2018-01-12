struct mystruct{
    int attr1;
    char attr2;
    int* pointer;
};
typedef int int2;
int main(){
    mystruct x;
    mystruct *y;
    int a[10] = {200};
    char s[10] = "4xxx";
    int2 z;
    x.attr1 = 10;
    y->attr2 = 7;
    z = 10;
    int i;
    for(i = 0 ; i < 5; i = i + 2){
        if(i == 2){
            continue;
        }
        printf("%d",a[s[0]-'0' + y->attr2 - x.attr1 - 1]);
    }
    return 0;
}

