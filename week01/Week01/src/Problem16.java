public class Problem16 {
    //Rescale
   public static int[][] rescale(int[][] original, int newWidth, int newHeight){
       int[][] rescaled=new int[newWidth][newHeight];
       int oldWidth=original.length;
       int oldHeight=original[0].length;
       for(int i=0;i<newWidth;i++){
           for(int j=0;j<newHeight;j++){
               int new_i=i *(oldWidth/newHeight);
               int new_j=j *(oldWidth/newHeight);
               rescaled[new_i][new_j]=original[i][j];
           }
       }
       return rescaled;
   }
   public static void main(String[] args){
       
   }
}
