package model;

class E2 {
    public static int sumaPares(int [] vector){
        int s=0;
        for (int i=0; i<vector.length; i++){
            if (vector[i]>=0 && vector[i]%2==0){
                s+=vector[i];

            }

        }

        return s;
    }

}
