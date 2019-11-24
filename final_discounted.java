public static void finalPrice(List<Integer> prices) {
    
    Stack<Integer> stack = new Stack();
        List<Integer> indices = new ArrayList();
        long cost = 0;

    for(int i = prices.size() - 1; i >= 0; i--) {
        int curPrice = prices.get(i);
        while(!stack.isEmpty() && curPrice < stack.peek()) {
            stack.pop();
        }
        if(stack.isEmpty()) {
            indices.add(i);
            cost += curPrice;
        } else {
            cost += (curPrice - stack.peek());
        }
        stack.push(curPrice);
    }

    System.out.println(cost);
    Collections.reverse(indices);
    int k = 0;
    for(int i : indices) {
        System.out.print(i);
        if(k++ != indices.size() - 1) {
            System.out.print(" ");
        }
    }
    }
}

