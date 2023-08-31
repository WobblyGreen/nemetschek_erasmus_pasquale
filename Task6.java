public class Task6 {
    public static int main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        int j = height.length-1;
        int area=0;
        for(int i=0; i<j;){
            int tmp_area = (height[i]<height[j] ? height[i]:height[j])*(j-i);
            if(tmp_area>area) area=tmp_area;

            if(height[i]<height[j]) i++;
            
            else j--;
        }
        System.out.println(area);
        return area;
    }

}
