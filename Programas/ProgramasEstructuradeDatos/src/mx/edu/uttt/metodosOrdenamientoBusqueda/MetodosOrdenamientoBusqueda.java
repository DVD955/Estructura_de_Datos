package mx.edu.uttt.metodosOrdenamientoBusqueda;

public class MetodosOrdenamientoBusqueda {

public int arr[];

    public MetodosOrdenamientoBusqueda(int tam){
        if(validartamanio(tam)) {
            arr = new int[tam];
        }else{
            arr = new int[2];

        }





    }
    private boolean  validartamanio(int tam){
        return  tam > 0;

    }

    public int [] getArr() {
        return arr;
    }

    public void setArr(int [] arr) {
        if (this.arr.length == arr.length){
            for(int i = 0 ; i < arr.length; i++){

            }
        }

    }

    public void bubleSortAsc(){
  int aux = 0;
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr.length-1; j++){

                if (arr[j] > arr[j+1]){
                    aux = arr[j];
                    arr[j] = aux;
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;


                }




            }

        }
    }
    public void bubleSortDesc() {
        int aux = 0;
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr.length - 1; j++) {

                if (arr[j] < arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = aux;
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }
}
