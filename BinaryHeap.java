public class BinaryHeap{
	int size;
	int[] a=new int[10];

	public void add (int i){
		if(size==a.length){
			growArr();
		}
		a[size]=i;
		size++;
		int item=size-1;
		while(item>0){
			int parent=(item-1)/2;
			if(a[item]<a[parent]){
				swap(a,item,parent);
				item=parent;
			}
			else{
				return;
			}
		}
	}	
	public int remove(){
		if(size==0){
			throw new IllegalArgumentException("empty heap");
		}
		int priority=a[0];
		a[0]=a[size-1];
		--size;
		shiftdown(0);
		return priority;
	}
	private void shiftdown(int index){
		int child=(index*2)+1;
		if (child>=size){
			return;
		}
		if(a[child+1]<a[child]){
			child=child+1;
		}
		if(a[index]>a[child]){
			swap(a,index,child);
			shiftdown(child);
		}
	}
	public void growArr(){
		int[] temp=new int[a.length*2];
		for (int i=0;i<a.length;i++){
			temp[i]=a[i];
			}
		a=temp;
	}
	public void swap(int[]a,int i, int k){
		int tep=a[i];
		a[i]=a[k];
		a[k]=tep;
	}
} 