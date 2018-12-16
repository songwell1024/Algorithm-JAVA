package BasicExample.BasicExamples07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author WilsonSong
 * @date 2018/12/16/016
 */
public class Code_08_BestArrange {
    public class Programs{
        public int start;
        public int end;
        public Programs(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public int getProgramsNum(Programs[] programs, int start){
        Arrays.sort(programs, new Comparator<Programs>() {
            @Override
            public int compare(Programs o1, Programs o2) {
                return o1.end - o2.end;
            }
        });

        int res = 0;
        for (int i = 0; i < programs.length; i++){
            if (start <= programs[i].start){
                res++;
                start = programs[i].end;
            }
        }
        return res;
    }



}
