package com.company;
/*
 * Date: 2020/Apr/16
 * Problem #16:
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 */

import java.util.Stack;

/*
 * Thinking:
 * Usually this problem will be solved by using a stack,
 * the only difference here is that we have a wildcard '*'
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> wd = new Stack<>();

        for(int i=0; i<s.length();i++){
            if(chars[i]=='('){
                st.push(i);
            }else if(chars[i] == '*'){
                wd.push(i);
            }else{
                if(st.isEmpty() && wd.isEmpty()) return false;
                else if(!st.isEmpty()) st.pop();
                else wd.pop();
            }
        }

        while(!st.isEmpty() && !wd.isEmpty() ){
            if(st.peek()>wd.peek()) return false;
            st.pop();
            wd.pop();
        }

        if(!st.isEmpty()) return false;

        return true;
    }
}
/*
 * At first I got it wrong for ignoring "*(" solution
 * But this can be solved by using Integer stack instead of character
 * through peeking at the top item, one can easily compare the time they're added
 */
