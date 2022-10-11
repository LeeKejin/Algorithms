package com.algorithms.array.leetcode;

import java.util.PriorityQueue;

public class Leet215
{
    public int findKthLargestEasyToUnderstand( int[] nums, int k )
    {
        int[] res = quickSortImplement( nums, 0, nums.length );

        return res[ nums.length - k ];
    }

    public int[] quickSortImplement( int[] arr, int l, int r )
    {
        if ( l >= r ) return arr;
        int pivot = partition( arr, l, r );
        int temp = arr[ pivot ];
        arr[ pivot ] = arr[ l ];
        arr[ l ] = temp;
        quickSortImplement( arr, l, pivot );
        quickSortImplement( arr, pivot + 1, r );
        return arr;
    }

    public int partition( int[] arr, int start, int end )
    {
        if ( start >= end ) return start;
        int pivot = arr[ start ];
        int j = start + 1;
        for ( int i = start + 1; i < end; i++ )
        {
            if ( arr[ i ] >= pivot ) continue;
            else
            {

                int temp = arr[ i ];
                arr[ i ] = arr[ j ];
                arr[ j ] = temp;
                j++;
            }
        }
        return j - 1;
    }

    public static int findKthLargest( int[] nums, int k )
    {
        PriorityQueue< Integer > q = new PriorityQueue< Integer >( k );
        for ( int i : nums )
        {
            q.add(i);

            if (q.size() > k) {
                int j = q.poll();
            }
        }

        return q.peek();
    }

    public int findKthLargestPivotMethod(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[end];
        while (true) {
            if (nums[left] < pivot && left < right) {
                left++;
            }
            if (nums[right] >= pivot && left < right) {
                right--;
            }
            if (right == left) {
                break;
            }
            swap( nums, left, right );
        }
        swap( nums, left, end );
        if ( left + 1 == k )
        {
            return pivot;
        }
        else if ( k < left + 1 ) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }

    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 1, 5, 6, 4};
    }
}
