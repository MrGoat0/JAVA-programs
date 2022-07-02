package model;

class E5 {
    public static int[] sumaVectorial(int [] v1, int [] v2){
        int[] s= new int[v1.length];

        for (int i=0; i< v1.length;i++){
            s[i]=(v1[i]+v2[i]);
        }
        return s;
    }
}
