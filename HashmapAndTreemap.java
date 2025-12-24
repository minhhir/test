import java.util.*;
public class HashmapAndTreemap{
  public static void main(String[] args){
    final int N=100000;
    final int MaxKey=200000;
    List<Integer> keys= new ArrayList<>();
    Random random=new Random();
    for (int i=0;i<N;i++){
      keys.add(random.nextInt(MaxKey));
    }
    //HASHMAP
    System.out.println("\n1. HASHMAP:");
    Map<Integer,Integer> hashMap = new HashMap<>();
    testMapPerformance(hashMap,keys,"HashMap");
    //TREEMAP
    System.out.println("\n2. TREEMAP:");
    Map<Integer, Integer> treeMap = new TreeMap<>();
    testMapPerformance(treeMap,keys,"TreeMap");
  }
  public static void testMapPerformance(Map<Integer,Integer> map, List<Integer> keys,String mapName){
    long start, end;
    //Them phan tu
    start= System.nanoTime();
    for(Integer key: keys){
      map.put(key,key*10);
    }
    end = System.nanoTime();
    System.out.println("-Thời gian Put "+keys.size()+" phần tử: "+(end-start)/1000000+" ms");
    //in 5 phan tu dau tien
    System.out.print("-Thứ tự Key lưu trữ (5 phần tử đầu): ");
    int count = 0;
    for (Integer key : map.keySet()) {
      System.out.print(key + " ");
      count++;
      if (count >= 5) break;
    }
    //lay gia tri(get)-truy xuất toàn bộ key
    start=System.nanoTime();
    for(Integer key:keys){
      map.get(key);
    }
    end=System.nanoTime();
    System.out.println("-Thời gian Get (truy xuất toàn bộ): "+(end-start)/1000000+" ms");
    //Kiem tra ton tai
    start = System.nanoTime();
    for (int i=0;i<keys.size()/2;i++) {
      map.containsKey(keys.get(i));
    }
    end = System.nanoTime();
    System.out.println("-Thời gian ContainsKey ("+(keys.size()/2)+" lần): "+(end-start)/1000000+" ms");
    //Xoa phan tu
    start=System.nanoTime();
    for(Integer key:keys) {
      map.remove(key);
    }
    end = System.nanoTime();
    System.out.println("-Thời gian Remove toàn bộ: " + (end-start)/1000000+" ms");
  }
}
