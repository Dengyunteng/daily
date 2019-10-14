package cn.alogi;

public class 正则匹配 {
}
class Pattern{
    private boolean matched = false;
    private char[] pattern;
    private int pLen;

    public Pattern(char[] pattern, int pLen){
        this.pattern = pattern;
        this.pLen = pLen;
    }

    public boolean match(char[] text, int tLen){
        matched = false;
        rmatch(0, 0, text, tLen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tLen){
        if(matched) return;
        if(pj == pLen){
            if(ti == tLen) matched = true;
            return;
        }

        if(pattern[pj] == '*'){
            for(int k = 0; k <= tLen - ti; k++){
                rmatch(ti + k, pj + 1, text, tLen);
            }
        }else if(pattern[pj] == '?'){
            rmatch(ti, pj + 1, text, tLen);
            rmatch(ti + 1, pj + 1, text, tLen);
        }else if(ti < tLen && pattern[pj] == text[ti]){
            rmatch(ti + 1, pj + 1, text, tLen);
        }
    }
}
