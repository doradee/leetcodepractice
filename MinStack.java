package solutions;

import java.util.Stack;

/*
 * 
 Design a stack that supports push, pop, top, and retrieving the minimum 
 element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
  
  /* Accepted. Inspired by discussion */
  Stack<Integer> realstack = new Stack<Integer>();
  Stack<Integer> minstack  = new Stack<Integer>();
  
  public void push(int x) {
    if (minstack.isEmpty() || minstack.peek() >= x) {
      minstack.push(x);
    }
    realstack.push(x);
  }
  
  public void pop() {
    if (realstack.peek() == minstack.peek()) {
      minstack.pop();
    }
    realstack.pop();
  }
  
  public int top() {
    return realstack.peek();
  }
  
  public int getMin() {
    return minstack.peek();
  }
}
