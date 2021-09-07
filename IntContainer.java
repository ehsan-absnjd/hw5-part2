package IntContainer;
public class IntContainer {
    private int[] array = new int[1];
    private int index=0;
    public void add(int num){
        if(index == array.length){
            int[] newarr = new int[array.length*2];
            for(int i=0;i<array.length;i++){
                newarr[i]=array[i];
            }
            array=newarr;
        }
        array[index++]=num;
    }
    public int indexOf(int num){
        for(int i=0; i<index;i++){
            if(array[i]==num)
                return i;
        }
        return -1;
    }
    public boolean contains(int num){
        int index = indexOf(num);
        return index==-1 ? false : true;
    }
    public void removeByVal(int num){
        int ind = indexOf(num);
        while(ind!=-1) {
            removeByIndex(ind);
            ind=indexOf(num);
        }
    }
    public void removeByIndex(int ind){
        if(ind<0 || ind >=index)
            return;
        for(int i= ind;i<index-1;i++)
            array[i] = array[i+1];
        index--;
    }
    public void print(){
        System.out.print("{ ");
        for (int i=0; i<index;i++){
            if(i !=index-1) {
                System.out.print(array[i] + " , ");
            }else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("}");
    }
    public void ascSort(){
        outer : for(int i=1; i<index;i++){
            boolean isSorted = true;
            inner : for( int j=1; j<index; j++){
                if(array[j]>=array[j-1]) {
                    continue;
                } else{
                    int tmp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    isSorted =false;
                }
            }
            if(isSorted)
                break outer;
        }
    }
    public void dscSort(){
        outer : for(int i=1; i<index;i++){
            boolean isSorted = true;
            inner : for( int j=index-1; j>=1; j--){
                if(array[j]<=array[j-1]) {
                    continue;
                } else{
                    int tmp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    isSorted =false;
                }
            }
            if(isSorted)
                break outer;
        }
    }
    public void removeByVal2(int num){
        int count =0;
        for(int i= 0;i<index;i++) {
            while (i+count < index && array[i + count] == num) {
                count++;
            }
            if(i+count>=index)
                break;
            array[i] = array[i + count];
        }
        index-=count;
    }
}
