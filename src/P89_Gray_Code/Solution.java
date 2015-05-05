package P89_Gray_Code;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> result =new ArrayList<Integer>();
       int nSize=1<<n;
       for (int i = 0; i < nSize; ++i)
           result.add((i>>1)^i);
       return result;
    }
}
