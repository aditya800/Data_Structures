long count = 0;
for(long i = 1; i * i <= n; i++) {
    if(n % i == 0) {
        count++;
    }
    if(count == p) {
        return (long) i;
    }
}

count++;
return (p > count ? 0 : n);
