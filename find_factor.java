        List<Long> l1 = new ArrayList();
        List<Long> l2 = new ArrayList();
        
        for(long i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                l1.add(i);
                if(i != Math.sqrt(n)) {
                    l2.add(n / i);
                }
            }
        }
        
        Collections.reverse(l2);
    
        if(p > (l1.size() + l2.size())) {
            return 0;
        }
        
        if(p <= l1.size()) {
            return l1.get((int) p - 1);
        } else {
            return l2.get((int) p - l1.size() - 1);
        }
