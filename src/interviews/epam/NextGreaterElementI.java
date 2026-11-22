package interviews.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    /*
     * For each value in nums1, find its occurrence in nums2 and return the
     * first strictly greater value to its right, or -1 if none exists.
     *
     * Input: int[] nums1 and int[] nums2, each containing distinct values
     * from 0 to 10,000. Every value in nums1 appears in nums2.
     * Constraints: 1 <= nums1.length <= nums2.length <= 1,000.
     * Output: an int[] of answers in nums1 order.
     * Target time: O(nums1.length + nums2.length).
     *
     * Examples:
     * nums1 = [4, 1, 2], nums2 = [1, 3, 4, 2] -> [-1, 3, -1]
     * nums1 = [2, 4], nums2 = [1, 2, 3, 4] -> [3, -1]
     * nums1 = [3, 1], nums2 = [3, 1, 4, 6] -> [4, 4]
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i=nums2.length-1; i>=0; i--){
            while(st.peek()!=-1 && nums2[i]>st.peek()){
                st.pop();
            }
            greaterMap.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            ans[i] = greaterMap.get(nums1[i]);
        }

        return ans;
    }
}
