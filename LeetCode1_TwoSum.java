import java.util.Hashtable;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = {0,0};
        Hashtable<Integer,Integer> hashTable = new Hashtable<Integer,Integer>(); //定义存储数据的hashtable
        for(int index=0;index<nums.length;index++) { //便利数组，将数据存入hashtable
            hashTable.put(nums[index],index); //key为数组中元素的值，value为该元素在数组中的位置
        }
        for(int index=0;index<nums.length;index++) { //便利查找元素
            int pairValue = target - nums[index];
            if((hashTable.get(pairValue)!=null)&&(hashTable.get(pairValue)>index)) { //找到了另一个元素 并且找到的不能是自己
                result[0] = index+1;
                result[1] = hashTable.get(pairValue)+1;
                break;//找到了就退出
            }
        }
        return result;
    }
}