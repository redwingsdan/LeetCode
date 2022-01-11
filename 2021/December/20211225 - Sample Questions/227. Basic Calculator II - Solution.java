class Solution {
    public int calculate(String s) {
        //Remove whitespace
        s = s.replace(" ", "");
        //Split elements from operators
        String[] elements = s.split("[\\+\\-\\*\\/]");
        Stack<Integer> stack = new Stack<>();
        //Add the first item to the stack and set the pointer to the first operator
        stack.push(Integer.parseInt(elements[0]));
        int opPointer = elements[0].length();
        //Iterate through each element
        for (int i = 1; i < elements.length; i++) {
            //Get the next operator and element
            String operator = s.substring(opPointer, opPointer+1);
            int element = Integer.parseInt(elements[i]);
            //Handle the operation
            if ("+".equals(operator)) {
                stack.push(element);
            } else if ("-".equals(operator)) {
                stack.push(-element);
            } else if ("*".equals(operator)) {
                stack.push(stack.pop() * element);
            } else if ("/".equals(operator)) {
                stack.push(stack.pop() / element);
            }
            opPointer += 1 + elements[i].length();
        }
        //Add the items in the stack together
        int answer = 0;
        for (int item: stack) {
            answer += item;
        }
        return answer;
    }
}
