package model;

class E3 {
    public static double mean(int[] vector){
        double promedio;
        double suma = 0;
        int cont = 0;

        for(int i=0; i<vector.length;i++){
            suma+=vector[i];
            cont++;
        }
        promedio = (suma/cont);
        return promedio;
    }
}
