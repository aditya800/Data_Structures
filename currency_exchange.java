public static void findBestExchangeRate(int expediaCoins, int localCurrencyAmount, List<String> currencyCodes, List<Float> expediaToLocalRates, List<Float> localToExpediaRates) {

            
        int max = 0;
        HashMap<String, Integer> map2 = new HashMap();
        for(int i = 0; i < currencyCodes.size(); i++) {

        float exchange1 = (float) expediaCoins * expediaToLocalRates.get(i);    
                exchange1 -= localCurrencyAmount;
                exchange1 = Math.round(exchange1 * localToExpediaRates.get(i));
                max = Math.max(max, (int) exchange1);
                map2.put(currencyCodes.get(i), (int) exchange1);
            }
            
            PriorityQueue<String> pq = new PriorityQueue<>();
            for(Map.Entry<String, Integer> entry : map2.entrySet()) {
                if(entry.getValue() == max) {
                    pq.add(entry.getKey());
                }
                if(pq.size() > 1) {
                    pq.poll();
                }
            }

            System.out.println(pq.peek());
            System.out.println(max);

    }
