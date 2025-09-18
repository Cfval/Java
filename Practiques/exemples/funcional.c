typedef int (*opBinaria) (int, int);

int sumar(int a, int b){ return a + b; }

int multiplicar(int a, int b){ return a * b; }

void executar(opBinaria f, int op1, int op2){
    int resultat = f(op1, op2);
    printf("%d\n", resultat);
}

int main(){
    executar(sumar,1,2);
    executar(multiplicar,1,2);
    return 0;
}
